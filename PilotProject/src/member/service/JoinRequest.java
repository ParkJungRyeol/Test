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

	public void validate(Map<String, Boolean> errors) { //��ȿ�� �˻�
		checkEmpty(errors, id, "id"); //id
		checkEmpty(errors, name, "name"); //name
		checkEmpty(errors, password, "password"); //password
		checkEmpty(errors, confirmPassword, "confirmPassword"); //confirmPassword
		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) { //��й�ȣ�� ��й�ȣ Ȯ�� �� �������� Ȯ��
				errors.put("notMatch", Boolean.TRUE);
			}
		}
	}

	private void checkEmpty(Map<String, Boolean> errors, 
			String value, String fieldName) { // ����ִ��� �˻��ϴ� �޼ҵ�
		if (value == null || value.isEmpty())  
			errors.put(fieldName, Boolean.TRUE);
	}
}
