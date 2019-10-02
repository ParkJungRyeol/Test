package guest_message.model;

import java.util.Map;

//model class (Data, VO)
public class Guest_message {
	
	private int message_id;
	private String guest_name;
	private String password;
	private String message;
	public Guest_message() {
		
	}
	public Guest_message(String guest_name, String password, String message) {
		this.guest_name = guest_name;
		this.password = password;
		this.message = message;
	}
	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", guest_name=" + guest_name + ", password=" + password
				+ ", message=" + message + "]";
	}
	public int getMessage_id() {
		return message_id;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public String getPassword() {
		return password;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
//		return password != null && password.equals(pwd);
	}
	public void validate(Map<String, Boolean> errors) { //유효성 검사
		checkEmpty(errors, guest_name, "guest_name"); //id
		checkEmpty(errors, password, "password"); //name
		checkEmpty(errors, message, "message"); //password
	
	}
	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) { // 비어있는지 검사하는 메소드
		if (value == null || value.isEmpty())  
			errors.put(fieldName, Boolean.TRUE);
	}
}
