package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.model.Article;
import article.service.AddService;
import article.service.ArticleRequestService;
import auth.service.User;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class AddHandler implements CommandHandler {

//	private static final String FORM_VIEW = "/article/articleAdd.jsp";
	private AddService addService = new AddService();
	private ArticleRequestService requestService = new ArticleRequestService();


	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("add�ڵ鷯");
		Article article = new Article();
		article.setTitle(req.getParameter("title"));
		article.setContent(req.getParameter("content"));
		HttpSession session = req.getSession();
		User auth = new User();
		auth = (User) session.getAttribute("authUser");

	
		System.out.println("title: " +req.getParameter("title"));
		System.out.println("content: " +req.getParameter("content"));
		article.setWriter_id(auth.getId());
		article.setWriter_name(auth.getName());
		
			addService.articleadd(article);
			return "articlelist.do";

	}
}
