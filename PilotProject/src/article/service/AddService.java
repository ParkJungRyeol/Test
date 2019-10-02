package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class AddService {
	private static ArticleDao articleDao = new ArticleDao();

	public void articleadd(Article article) {
		Connection conn = null;
		try {
			System.out.println("애드서비스");
			conn = ConnectionProvider.getConnection(); 
			conn.setAutoCommit(false);

			articleDao.add(conn, article);
			conn.commit();

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
