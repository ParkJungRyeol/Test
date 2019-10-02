package guest_message.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest_message.service.GetMessageListService;
import guest_message.service.MessageListView;
import mvc.command.CommandHandler;

//방명록 보기 이벤트 핸들러
//guest_message/list.do가 요청되면 방명록 목록을 읽어 list.jsp로 포워딩
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
//읽는 요청만 있어서 GetMessageListHandler의 process()메서드 따로 나누지 X