package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ListService {
	private static ArticleDao articleDao = new ArticleDao();

	public List articlePrintList(int page) {
		Map articlesMap1 = new HashMap();
		Connection conn = null;
		try {
		conn = ConnectionProvider.getConnection(); 
		conn.setAutoCommit(false);
		List articlesList = articleDao.selectAllMember(conn, page);
		
			System.out.println("¼­ºñ½º");
			conn.commit();
			return articlesList;

//			if (member != null) {
//				JdbcUtil.rollback(conn);
//				throw new SessionException();
//			}

//			memberDao.insert(conn, new Member(joinReq.getId(), joinReq.getName(), joinReq.getPassword(), new Date()));
//			conn.commit();
		} catch (NamingException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
//	}
	}
}
