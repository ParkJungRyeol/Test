package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import article.model.Article;
import jdbc.JdbcUtil;
import member.model.Member;

public class ArticleDao {

	public List<Article> selectAllMember(Connection conn, int page) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Article article = null;
		List<Article> list = new ArrayList<Article>();

		int startNum = (page - 1) * 10 ;
		int endNum = (page * 10)-1;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM (" + "SELECT * FROM (" + "SELECT ROWNUM row_num, article.* FROM article"
							+ ") WHERE row_num >= ?" + ") WHERE row_num <= ? order by row_num");

			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				article = new Article(rs.getString("article_no"), rs.getString("writer_name"), rs.getString("title"),
						rs.getString("read_cnt"), toDate(rs.getTimestamp("regdate")),
						toDate(rs.getTimestamp("regdate")));
				
				article.setRead_cnt(rs.getString("read_cnt"));
				System.out.println("조회수="+article.getRead_cnt());
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return list;
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public Article content(Connection conn, String no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Article article = null;
		try {
			List list = new ArrayList();

			pstmt = conn.prepareStatement(
					"select a.article_no, a.writer_name, a.title, ac.content" + " from article a, article_content ac"
							+ " where a.article_no = ac.article_no" + " and a.article_no = ?");
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				article = new Article(rs.getString("article_no"), rs.getString("writer_name"), rs.getString("title"),
						rs.getString("content"));
			}

			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public void add(Connection conn, Article article) throws SQLException {
		System.out.println("애드dao");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;


		try {
			pstmt = conn.prepareStatement(
					"insert into article (article_no, writer_id, writer_name, title, regdate, moddate, read_cnt) values(article_no_seq.nextval,?,?,?,sysdate,sysdate,0)");
			pstmt.setString(1, article.getWriter_id());
			pstmt.setString(2, article.getWriter_name());
			pstmt.setString(3, article.getTitle());	
			pstmt.executeUpdate();		

		
			pstmt2 = conn.prepareStatement(
					"insert into article_content (article_no, content) values(article_no_seq1.nextval,?)");
			pstmt2.setString(1, article.getContent());
			pstmt2.executeUpdate();
			


		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);

		}

	}

	public void delete(Connection conn, String no) throws SQLException {
		System.out.println("딜리트 dao , no" + no);
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		try {

			pstmt = conn.prepareStatement("delete from article where article_no = ?");
			pstmt.setString(1, no);
			pstmt.executeUpdate();

			pstmt2 = conn.prepareStatement("delete from article_content where article_no = ?");
			pstmt2.setString(1, no);
			pstmt2.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);

		}
	}

	public void edit(Connection conn, Article article) throws SQLException {
		System.out.println("edit dao");
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;


		try {

			pstmt = conn.prepareStatement("update article set title = ? where article_no = ?");
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getArticle_no());
			pstmt.executeUpdate();

			pstmt2 = conn.prepareStatement("update article_content set content = ? where article_no = ?");
			pstmt2.setString(1, article.getContent());
			pstmt2.setString(2, article.getArticle_no());
			pstmt2.executeUpdate();
			
			pstmt3 = conn.prepareStatement("update article set moddate = sysdate where article_no = ?");
			pstmt3.setString(1, article.getArticle_no());
			pstmt3.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(pstmt3);

		}
	}

	public void increaseReadCount(Connection conn, String no) throws SQLException {
		System.out.println(no);
		System.out.println("카운트 증가");
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement("update article set read_cnt = read_cnt + 1 where article_no = ?");
			pstmt.setString(1, no);
			pstmt.executeQuery();
		}
				finally {
			JdbcUtil.close(pstmt);
		}
	}
}