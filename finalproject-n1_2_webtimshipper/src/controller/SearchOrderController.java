package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.SearchOrder;
import model.UserOrder;

@WebServlet(name = "searchOrderServlet", value = "/home-shop/search-order")
public class SearchOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public SearchOrderController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/search-order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SearchOrder searchOrder = new SearchOrder();
		String orderId = request.getParameter("order_id");
		searchOrder.setUserOrderId(Integer.parseInt(orderId));
		UserOrder order = userOrderDAO.searchLocationOrder(searchOrder);
		request.setAttribute("orders", order);
		System.out.println(order.getLat3());

		RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/search-order.jsp");
		rd.forward(request, response);
	}

}
