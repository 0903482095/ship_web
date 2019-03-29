package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.SearchOrder;
import model.UserOrder;
import utils.UserOrderStatus;

@WebServlet(name = "shipperServlet", value = "/home-shipper")
public class ShipperController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public ShipperController() {
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
		SearchOrder searchOrder = new SearchOrder();
		List<UserOrder> userOrders = userOrderDAO.searchOrder(searchOrder);
		List<UserOrder> pendingOrders = new ArrayList<UserOrder>();
		userOrders.forEach(userOrder ->{
			if(userOrder.getStatus() == UserOrderStatus.PENDING) {
				pendingOrders.add(userOrder);
			}
		});
		request.setAttribute("orders", userOrders);
		RequestDispatcher rd = request.getRequestDispatcher("/admin-shipper/home-shipper.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
