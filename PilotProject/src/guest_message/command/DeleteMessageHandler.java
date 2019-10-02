package guest_message.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest_message.service.DeleteMessageService;
import guest_message.service.InvalidPasswordException;
import mvc.command.CommandHandler;

public class DeleteMessageHandler implements CommandHandler{
	private static final String FORM_VIEW = "/guest_message/ConfirmDeletion.jsp";
	private DeleteMessageService deleteService = new DeleteMessageService();
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("DeleteMessageHandler process GET");
			return processForm(request, response);
		}else if(request.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("DeleteMessageHandler process POST");
			return processSubmit(request, response);
		}else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest request, HttpServletResponse response) {
		return FORM_VIEW;
	}
	private String processSubmit(HttpServletRequest request, HttpServletResponse response) {
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		String password = request.getParameter("password");
		boolean invalidPassword = false;
		try {
			deleteService.deleteMessage(messageId, password);
		}catch(InvalidPasswordException ex) {
			invalidPassword = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("invalidPassword", invalidPassword);
		return "/guest_message/deleteMessage.jsp";
	}
}
