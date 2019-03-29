package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import model.User;

@WebServlet(name = "registerServlet", value = "/register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	final String UPLOAD_FOLDER = "D:\\ky 7\\LTM\\QuestionLib\\WebApp-Ship\\WebContent\\images";
	private UserDAO userDAO;

	public RegisterController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		userDAO = new UserDAOImpl();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String roleId = request.getParameter("role");
		String lat = request.getParameter("lat");
		String lng = request.getParameter("lng");

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setAddress(address);
		user.setRoleId(Integer.parseInt(roleId));
		user.setLat(Float.parseFloat(lat));
		user.setLng(Float.parseFloat(lng));

		userDAO.register(user);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);

	}

}
