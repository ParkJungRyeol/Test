package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.model.Article;
import article.service.AddService;
import article.service.ArticleRequestService;
import article.service.DeleteService;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class DeleteHandler implements CommandHandler {
	

//	private static final String FORM_VIEW = "/article/articleAdd.jsp";
	private DeleteService deleteService = new DeleteService();


	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		String no = (req.getParameter("articleno"));


			deleteService.articledelete(no);
			return "articlelist.do";

	}

}
