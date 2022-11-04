package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class LogoutTest {

	String name;
	String pass;
	String role;
	ArrayList<User> users;

	public LogoutTest() {
		users = new ArrayList<User>();
		users.add(new Admin("Haya", "hayapass", "Admin"));
		users.add(new Secretary("Muath", "muathpass", "Secretary"));
		users.add(new Doctor("Abod", "abodpass", "Doctor"));
		users.add(new Patient("Ahmad", "ahmadpass", "Patient"));

		users.get(0).login("Haya", "hayapass");
		users.get(1).login("Muath", "muathpass");
		users.get(2).login("Abod", "abodpass");
		users.get(3).login("Ahmad", "ahmadpass");
	}

	@Given("that the {string} is logged in")
	public void thatTheIsLoggedIn(String string) {
		int index = 0;
		if (string.equals("Admin"))
			index = 0;
		else if (string.equals("Secretary"))
			index = 1;
		else if (string.equals("Doctor"))
			index = 2;
		else if (string.equals("Patient"))
			index = 3;

		assertEquals(users.get(index).loginStatus, true);
	}

	@When("the {string} logs out")
	public void theLogsOut(String string) {
		int index = 0;
		if (string.equals("Admin"))
			index = 0;
		else if (string.equals("Secretary"))
			index = 1;
		else if (string.equals("Doctor"))
			index = 2;
		else if (string.equals("Patient"))
			index = 3;

		users.get(index).logout();
		assertEquals(users.get(index).loginStatus, false);
	}

}
