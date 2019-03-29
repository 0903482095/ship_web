package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.UserOrder;
import utils.UserOrderStatus;

@WebServlet(name = "editServlet", value = "/home-shop/edit")
public class EditOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public EditOrderController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id:" + id);
		UserOrder order = userOrderDAO.getUserOrderById(id);
		request.setAttribute("order", order);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-shop/edit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String lat1 = request.getParameter("lat1");
		String lng1 = request.getParameter("lng1");
		String fee = request.getParameter("fee");
		String lat2 = request.getParameter("lat2");
		String lng2 = request.getParameter("lng2");

		UserOrder order = new UserOrder();
		order.setId(Integer.parseInt(id));
		order.setCreatedBy(1);
		order.setContent(content);
		order.setLat1(Float.parseFloat(lat1));
		order.setLng1(Float.parseFloat(lng1));
		order.setFee(Long.parseLong(fee));
		order.setStatus(UserOrderStatus.PENDING);
		order.setLat2(Float.parseFloat(lat2));
		order.setLng2(Float.parseFloat(lng2));

		userOrderDAO.editUserOrder(order);
		response.sendRedirect(request.getContextPath() + "/home-shop/orders");
	}

}
