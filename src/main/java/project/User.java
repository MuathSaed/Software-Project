package project;

public class User {
	protected String name;
	protected String pass;
	protected String role;
	protected boolean loginStatus;

	public User(String name, String pass, String role) {
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.loginStatus = false;
	}

	public boolean login(String name, String pass) {
		this.loginStatus = this.name.equals(name) && this.pass.equals(pass);
		return this.loginStatus;
	}

	public boolean logout() {
		this.loginStatus = false;
		return this.loginStatus;
	}

	public boolean checkLoginStatus() {
		return this.loginStatus;
	}

}
