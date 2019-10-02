package guest_message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import guest_message.model.Guest_message;
import jdbc.JdbcUtil;

public class Guest_messageDao {

	public int insert(Connection conn, Guest_message message) throws SQLException {
		PreparedStatement pstmt = null;
		try {pstmt = 
				conn.prepareStatement("insert into guestbook_message "
						+ "(message_id,guest_name,password,message) "
						+ "values (message_id_seq.nextval, ?, ?, ?)");
			System.out.println("message.getGuest_name() : " + message.getGuest_name());
			pstmt.setString(1, message.getGuest_name());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public Guest_message select(Connection conn, int messageId) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select count(*) from guestbook_message");
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Guest_message> selectList(Connection conn, int firstRow, int endRow) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"SELECT * FROM (" +
						"SELECT ROWNUM no, sub.* from ( " +
							" SELECT * FROM guestbook_message " +
							" ORDER BY message_id desc)sub )" +
						" WHERE no BETWEEN ? AND ?");
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Guest_message> messageList = new ArrayList<Guest_message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				}while(rs.next());
				return messageList;
			}else {
				return Collections.emptyList();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
	
	public int delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(
					"delete from guestbook_message where message_id = ?");
			pstmt.setInt(1, messageId);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	private Guest_message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Guest_message message = new Guest_message();
		message.setMessage_id(rs.getInt("message_id"));
		message.setGuest_name(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	
}
