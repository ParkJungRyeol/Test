package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/auth/loginForm.jsp";
	private LoginService loginService = new LoginService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("LoginHandler process GET");
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("LoginHandler processSubmit");
		String memberid = req.getParameter("id");
		String password = req.getParameter("password");
		
		Map<String, Boolean> errors = new HashMap<>();
		
		if(memberid == null || memberid.isEmpty()) {
			errors.put("id", Boolean.TRUE);
		}
		if(password == null || password.isEmpty()) {
			errors.put("password", Boolean.TRUE);
		}
		req.setAttribute("errors", errors);
		
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			
			User user = loginService.login(memberid, password);
			req.getSession().setAttribute("authUser", user);
			res.sendRedirect("index.jsp");
			System.out.println("LoginHandler-Session: " + req.getSession(false));
			return null;
		}catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}catch (IOException e) {
			return FORM_VIEW;
		}
	}

}


