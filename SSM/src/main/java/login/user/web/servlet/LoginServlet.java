package login.user.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import login.user.domain.User;
import login.user.service.UserException;
import login.user.service.UserService;

/**
 * userservlet层
 * @author hp
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		//依赖UserService
		UserService userService = new UserService();
		
		/*
		 * 1.封装表单数据到User form中
		 * 2.调用service的login()方法，得到返回的User user对象
		 * 	>如果抛出异常：获取异常信息，保存到request域，再保存form，转发到login.jsp
		 *  >如果没有抛出异常：保存返回值到session中，重定向到welcome.jsp
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			User user = userService.login(form);
			request.getSession().setAttribute("sessionUser", user);
			response.sendRedirect(request.getContextPath() + "/login_jsp/welcome.jsp");//重定向
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/login_jsp/login.jsp").forward(request, response);;
		}
	}

}