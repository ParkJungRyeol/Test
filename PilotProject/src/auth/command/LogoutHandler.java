package auth.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession session = req.getSession();
		if(session != null) {
			session.invalidate();
			System.out.println("LogoutHandler-invalidate_Session: " + req.getSession(false));
		}
		res.sendRedirect("index.jsp");
		return null;
	}
}



