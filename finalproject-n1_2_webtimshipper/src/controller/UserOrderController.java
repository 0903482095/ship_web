package controller;

import java.io.IOException;
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

@WebServlet(name = "userOrderServlet", value = "/home-shop/orders")
public class UserOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public UserOrderController() {
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
		List<UserOrder> orders = userOrderDAO.searchOrder(searchOrder);
		System.out.println("size:" + orders.size());
		request.setAttribute("orders", orders);
		RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/home-shop.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
