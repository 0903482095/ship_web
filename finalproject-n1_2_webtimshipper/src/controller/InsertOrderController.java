package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserOrderDAO;
import dao.impl.UserOrderDAOImpl;
import model.UserOrder;
import utils.UserOrderStatus;

@WebServlet(name = "insertOrderServlet", value = "/home-shop/insert")
public class InsertOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserOrderDAO userOrderDAO;

	public InsertOrderController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		userOrderDAO = new UserOrderDAOImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/insert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String content = request.getParameter("content");
		String lat1 = request.getParameter("lat1");
		String lng1 = request.getParameter("lng1");
		String fee = request.getParameter("fee");
		String lat2 = request.getParameter("lat2");
		String lng2 = request.getParameter("lng2");
		String fromAdd = request.getParameter("fromAdd");
		String toAdd = request.getParameter("toAdd");
		HttpSession session = request.getSession();

		UserOrder order = new UserOrder();
		order.setCreatedBy((int) session.getAttribute("created_by_id"));
		order.setContent(content);
		order.setLat1(Float.parseFloat(lat1));
		order.setLng1(Float.parseFloat(lng1));
		order.setFee(Long.parseLong(fee));
		order.setStatus(UserOrderStatus.PENDING);
		order.setLat2(Float.parseFloat(lat2));
		order.setLng2(Float.parseFloat(lng2));

		order.setFromAdd(fromAdd);
		order.setToAdd(toAdd);

		if (userOrderDAO.addUserOrder(order) == true) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/home-shop.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin-shop/insert.jsp");
			rd.forward(request, response);
		}
	}
}
