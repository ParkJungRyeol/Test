package member.service;

import java.util.Map;

public class JoinRequest {

	private String id;
	private String name;
	private String password;
	private String confirmPassword;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}

	public void validate(Map<String, Boolean> errors) { //유효성 검사
		checkEmpty(errors, id, "id"); //id
		checkEmpty(errors, name, "name"); //name
		checkEmpty(errors, password, "password"); //password
		checkEmpty(errors, confirmPassword, "confirmPassword"); //confirmPassword
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) { //비밀번호와 비밀번호 확인 이 동등한지 확인
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) { // 비어있는지 검사하는 메소드
		if (value == null || value.isEmpty())  
			errors.put(fieldName, Boolean.TRUE);
	}
}
