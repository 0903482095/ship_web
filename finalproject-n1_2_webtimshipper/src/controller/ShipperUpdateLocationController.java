//package controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.UserOrderDAO;
//import dao.impl.UserOrderDAOImpl;
//import model.UserOrder;
//
//@WebServlet(name = "shipperUpdateLocationServlet", value = "/home-shipper/update-location")
//public class ShipperUpdateLocationController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private UserOrderDAO userOrderDAO;
//
//	public ShipperUpdateLocationController() {
//		super();
//	}
//
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		userOrderDAO = new UserOrderDAOImpl();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//
//		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println("id:" + id);
//		UserOrder order = userOrderDAO.getUserOrderById(id);
//		request.setAttribute("order", order);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-shipper/update-location.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String id = request.getParameter("id");
//		String lat3 = request.getParameter("lat3");
//		String lng3 = request.getParameter("lng3");
//
//		UserOrder order = new UserOrder();
//		order.setId(Integer.parseInt(id));
//		order.setLat3(Float.parseFloat(lat3));
//		order.setLng3(Float.parseFloat(lng3));
//
//		userOrderDAO.shipperUpdateLocation(order);
//
//		response.sendRedirect(request.getContextPath() + "/home-shipper");
//
//	}
//
//}
