package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.naming.NamingException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ArticleRequestService {
	private static ArticleDao articleDao = new ArticleDao();
	private Article article = new Article();

	public Article articleSet(String id) {
		Connection conn = null;
		try {
			System.out.println("리퀘스트서비스");
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);

//			article=articleDao.setList(conn, id);
			conn.commit();
			
			return article;

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
