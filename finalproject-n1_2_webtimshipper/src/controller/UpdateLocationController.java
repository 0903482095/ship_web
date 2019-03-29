package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.UserOrder;

/**
 * Servlet implementation class UpdateLocationController
 */
@WebServlet(name="UpdateLocationServlet",value="/home-shipper/update-location")
public class UpdateLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserOrderDAO userOrderDAO;
    public UpdateLocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<UserOrder> orders = new ArrayList<UserOrder>();
		HttpSession session = request.getSession();
		orders = userOrderDAO.getPickedOrders((int) session.getAttribute("created_by_id"));
		orders.forEach(order -> {
			System.out.println("content:" + order.getContent());
		});
		String orderJsons = new Gson().toJson(orders);
		request.setAttribute("orders", orders);
		request.setAttribute("orderJsons", orderJsons);
		RequestDispatcher rd = request.getRequestDispatcher("/admin-shipper/update-location.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
