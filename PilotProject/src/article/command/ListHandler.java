//로그인이 되었는지 확인해줘야함 아닐경우 로그인 페이지, 되있을 경우 리스트 출력
package article.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.dao.ArticleDao;
import article.model.Article;
import article.model.Paging;
import article.service.ListService;
import auth.service.User;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler {

//	private static final String List_Article = "/article/articleList.jsp";
//	private static final String GoIndex = "index.jsp";
	private ListService listservice = new ListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		User auth = new User();
		auth = (User) session.getAttribute("authUser");

		if(auth==null) {
			System.out.println("조건확인");
			return "index.jsp";

		}else {
			String authname = auth.getName();
			System.out.println(authname);
		 ArticleDao dao = new ArticleDao();
	        int page = 1;
	        if(req.getParameter("page")!=null){
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        Paging paging = new Paging();
	        paging.setPage(page);
	        paging.setTotalCount(44);
	        
	        List list = listservice.articlePrintList(page);
	        
	        req.setAttribute("artList", list);
	        req.setAttribute("paging", paging);
	        
			return "/article/articleList.jsp";
		}

		
//		if (req.getMethod().equalsIgnoreCase("GET")) {
//			return processForm(req, res);
//		} else if (req.getMethod().equalsIgnoreCase("POST")) {
//			return processSubmit(req, res);
//		} else {
//			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
//			return null;
//		}
//		return
	}
}
				
	
//	}
//	private String sessionIdentify(HttpServletRequest req, HttpServletResponse res) {
//		if(session.getAttribute("id"))

		//		JoinRequest joinReq = new JoinRequest();
//		joinReq.setId(req.getParameter("id"));
//		joinReq.setName(req.getParameter("name"));
//		joinReq.setPassword(req.getParameter("password"));
//		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));

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


