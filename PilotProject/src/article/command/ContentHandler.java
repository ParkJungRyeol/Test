//넘버 받아서 상세내용 출력
package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Article;
import article.service.ContentService;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class ContentHandler implements CommandHandler {

	private ContentService contentService = new ContentService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		String no = req.getParameter("articleno");
		Article article = contentService.contentout(no);
		req.setAttribute("article", article);
			return "/article/articleContent.jsp";
		}
	


//	private String processForm(HttpServletRequest req, HttpServletResponse res) {
//		return FORM_VIEW;
//	}
//
//	private String searchContent(HttpServletRequest req, HttpServletResponse res) {
//		JoinRequest joinReq = new JoinRequest();
//		joinReq.setId(req.getParameter("id"));
//		joinReq.setName(req.getParameter("name"));
//		joinReq.setPassword(req.getParameter("password"));
//		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
//
//		Map<String, Boolean> errors = new HashMap<>();
//		req.setAttribute("errors", errors);
//
//		joinReq.validate(errors);
//
//		if (!errors.isEmpty()) {
//			return FORM_VIEW;
//		}
//
//		try {
//			joinService.join(joinReq);
//			return "/view/joinSuccess.jsp";
//		} catch (DuplicateIdException e) {
//			errors.put("duplicateId", Boolean.TRUE);
//			return FORM_VIEW;
//		}
//	}

}
