package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.UserOrder;

@WebServlet(name = "pickUpOrderServlet", value = "/home-shipper/pick-up")
public class PickUpOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public PickUpOrderController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:" + id);
		UserOrder order = userOrderDAO.getUserOrderById(id);
		request.setAttribute("order", order);

		RequestDispatcher rd = request.getRequestDispatcher("admin-shipper/home-shipper.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserOrder order = new UserOrder();
		order.setId(Integer.parseInt(request.getParameter("id")));
		order.setShipperId((int) session.getAttribute("created_by_id"));

		userOrderDAO.shipperPickupOrder(order);
		response.sendRedirect("/WebApp-Ship/home-shipper/picked-orders");
	}

}
