package guest_message.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import guest_message.dao.Guest_messageDao;
import guest_message.model.Guest_message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	private Guest_messageDao guest_messageDao = new Guest_messageDao();
	
	public void deleteMessage(int messageId, String password) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Guest_message message = guest_messageDao.select(conn, messageId);
			if(message == null) {
				throw new MessageNotFoundException("�޽��� ����");
			}
			if(!message.matchPassword(password)) {
				throw new InvalidPasswordException("�н����尡 ��ġ���� ����");
			}
			guest_messageDao.delete(conn, messageId);
			
			conn.commit();
		}catch(SQLException ex) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("���� ����:" + ex.getMessage(), ex);
		}catch(InvalidPasswordException | MessageNotFoundException | NamingException ex) {
			JdbcUtil.rollback(conn);
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
}
