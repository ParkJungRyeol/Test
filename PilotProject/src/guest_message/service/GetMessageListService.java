package guest_message.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.naming.NamingException;

import guest_message.dao.Guest_messageDao;
import guest_message.model.Guest_message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class GetMessageListService {
	private Guest_messageDao guest_messageDao = new Guest_messageDao();
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	
	public MessageListView getMessageList(int pageNumber) { 
		Connection conn = null; 
		int currentPageNumber = pageNumber; 
		try { 
			conn = ConnectionProvider.getConnection();
			int messageTotalCount = guest_messageDao.selectCount(conn);
			
			List<Guest_message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			if (messageTotalCount > 0) {
				firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1 ;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
				System.out.println("firstRow : " +firstRow);
				System.out.println("endRow : " +endRow);
				messageList = guest_messageDao.selectList(conn, firstRow, endRow);
		}else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList,
				messageTotalCount, currentPageNumber,
				MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
		}catch (SQLException | NamingException e) {
			throw new ServiceException("목록 구하기 실패: " + e.getMessage(), e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
