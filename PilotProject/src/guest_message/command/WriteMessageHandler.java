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
		if(req.getMethod().equalsIgnoreCase("GET")) { // 기본 방명록 작성 조회
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) { // 방명록 등록 처리
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED); // 405 Error를 Header에 설정
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("WriteMessageHandler processSubmit");
		Guest_message message = new Guest_message(); // 화면의 Data를 담아 Validation 처리할 객체
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
			writeService.write(message); // 방명록 등록 처리
			return "/guest_message/writeMessage.jsp"; // 방명록 등록 성공 page	
		}catch (Exception e) {
			e.printStackTrace();
			return FORM_VIEW;
		}
	
	}
}
