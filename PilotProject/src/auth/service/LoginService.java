package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	private MemberDao memberDao = new MemberDao();
	
	public User login(String memberid, String password) throws LoginFailException{
		System.out.println("login");
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, memberid);
			System.out.println("member_id"+member);
			if(member == null) {
				System.out.println("로그인을 실패함");
				
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				System.out.println("로그인 비밀번호 일치하지 않음");
				throw new LoginFailException();
			}
			
			return new User(member.getId(), member.getName());
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
		}catch(NamingException e) {
			throw new RuntimeException();
		}
		return null;
	}

}
