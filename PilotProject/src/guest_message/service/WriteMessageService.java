package guest_message.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;

import guest_message.dao.Guest_messageDao;
import guest_message.model.Guest_message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.model.Member;

public class WriteMessageService {
	private Guest_messageDao guest_messageDao = new Guest_messageDao();
	
	public void write(Guest_message message) {
		System.out.println(message.toString());
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			guest_messageDao.insert(conn, message);
			conn.commit();
		}catch (SQLException | NamingException e) {
			throw new ServiceException("메시지 등록 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
