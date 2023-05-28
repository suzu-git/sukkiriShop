package model;

public class RegisterDTO {
	private String user_id;
	private String pass;
	private String mail;
	private String name;
	private int age;
	
	public RegisterDTO(String user_id, String pass,String mail, String name, int age) {
		this.user_id = user_id;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
		
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
