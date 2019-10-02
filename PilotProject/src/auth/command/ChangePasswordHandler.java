package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.ChangePasswordService;
import auth.service.InvalidPasswordException;
import auth.service.MemberNotFoundException;
import auth.service.User;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler{
	private static final String FORM_VIEW = "/auth/changePasswordForm.jsp";
	private ChangePasswordService changepasswordservice = new ChangePasswordService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("ChangePasswordHandler processSubmit");
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		
		User user = (User) req.getSession().getAttribute("authUser");
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if(newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		
		System.out.println("curPwd_before:"+curPwd);
		System.out.println("newPwd:"+newPwd);
		
		if ((!curPwd.isEmpty() && !newPwd.isEmpty()) && curPwd.equals(newPwd)){
				System.out.println("curPwd_bet:"+curPwd);
				System.out.println("newPwd:"+newPwd);
				
				errors.put("notcompare", Boolean.TRUE);
		}
		
		System.out.println("curPwd_After:"+curPwd);
		System.out.println("newPwd:"+newPwd);
		
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		
		try {
			changepasswordservice.changePassword(user.getId(), curPwd, newPwd);
			return "/auth/changePasswordSuccess.jsp";
		}catch(InvalidPasswordException e) {
			System.out.println("InvalidPasswordException");
			errors.put("notgoodPwd", Boolean.TRUE);
			return FORM_VIEW;
		}catch(MemberNotFoundException e) {
			System.out.println("MemberNotFoundException");
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
