package project;

public class Doctor extends User {
	protected boolean isAvailable;

	public Doctor(String name, String pass, String role) {
		super(name, pass, role);
		isAvailable = false;
	}

}
