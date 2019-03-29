package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/home-shop/*", "/home-shipper/*" })
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession();
		if (session.getAttribute("current_user") != null) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpResp = (HttpServletResponse) response;
			String url = httpReq.getRequestURI();
			if (url.contains("home-shop")) {
				httpResp.sendRedirect("/WebApp-Ship/login");
			} else if (url.contains("home-shipper")) {
				httpResp.sendRedirect("/WebApp-Ship/login");
			}
		}
		response.setCharacterEncoding("UTF-8");

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
