package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.User;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		userDAO = new UserDAOImpl();
		String username = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		User user = userDAO.login(username, password);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("current_user", user.getUsername());
			session.setAttribute("lat", user.getLat());
			session.setAttribute("lag", user.getLng());
			session.setAttribute("created_by_id", user.getId());
			if (user.getRoleId() == 1) {
				response.sendRedirect("home-shop/orders");
			} else {
				response.sendRedirect(request.getContextPath() + "/home-shipper");
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
