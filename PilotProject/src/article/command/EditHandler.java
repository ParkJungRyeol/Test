package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Article;
import article.service.DeleteService;
import article.service.EditService;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class EditHandler implements CommandHandler {

//	private static final String FORM_VIEW = "/article/articleAdd.jsp";
	private EditService editService = new EditService();


	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		Article article = new Article();
		article.setArticle_no(req.getParameter("article_no"));
		article.setTitle(req.getParameter("title"));
		article.setContent(req.getParameter("content"));




			editService.articleedit(article);
			return "articlelist.do";

	}

}
