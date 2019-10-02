package guest_message.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest_message.model.Guest_message;
import guest_message.service.WriteMessageService;
import member.service.DuplicateIdException;
import mvc.command.CommandHandler;

public class WriteMessageHandler implements CommandHandler {
	private static final String FORM_VIEW = "/guest_message/list.jsp";
	private WriteMessageService writeService = new WriteMessageService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		if(req.getMethod().equalsIgnoreCase("GET")) { // �⺻ ���� �ۼ� ��ȸ
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) { // ���� ��� ó��
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405 Error�� Header�� ����
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("WriteMessageHandler processSubmit");
		Guest_message message = new Guest_message(); // ȭ���� Data�� ��� Validation ó���� ��ü
		message.setGuest_name(req.getParameter("guest_name"));
		message.setPassword(req.getParameter("password"));
		message.setMessage(req.getParameter("message"));
		System.out.println("message: " + message.toString());
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		message.validate(errors);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		try {
			writeService.write(message); // ���� ��� ó��
			return "/guest_message/writeMessage.jsp"; // ���� ��� ���� page	
		}catch (Exception e) {
			e.printStackTrace();
			return FORM_VIEW;
		}
	
	}
}
