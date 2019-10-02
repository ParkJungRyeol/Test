package guest_message.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest_message.service.GetMessageListService;
import guest_message.service.MessageListView;
import mvc.command.CommandHandler;

//���� ���� �̺�Ʈ �ڵ鷯
//guest_message/list.do�� ��û�Ǹ� ���� ����� �о� list.jsp�� ������
public class GetMessageListHandler implements CommandHandler{
	private static final String FORM_VIEW = "/guest_message/list.jsp";
	private GetMessageListService messageListService = new GetMessageListService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNumberStr = req.getParameter("page");
		int pageNumber = 1;
		if(pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		MessageListView viewData = messageListService.getMessageList(pageNumber);
		req.setAttribute("viewData", viewData);
		return FORM_VIEW;
	}
}
//�д� ��û�� �־ GetMessageListHandler�� process()�޼��� ���� ������ X