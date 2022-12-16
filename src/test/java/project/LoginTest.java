package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class LoginTest {
	String name;
	String pass;
	String role;
	ArrayList<User> users;

	public LoginTest() {
		users = new ArrayList<User>();
		users.add(new Admin("Haya", "hayapass", "Admin"));
		users.add(new Secretary("Muath", "muathpass", "Secretary"));
		users.add(new Doctor("Abod", "abodpass", "Doctor"));
		users.add(new Patient("Ahmad", "ahmadpass", "Patient"));
	}

	@Given("That the {string} on the homepage")
	public void that_the_on_the_homepage(String string) {
		this.role = string;
	}

	@Given("the {string} user name is {string}")
	public void the_user_name_is(String string, String string2) {
		this.name = string2;
	}

	@Given("the {string} password is {string}")
	public void the_password_is(String string, String string2) {
		this.pass = string2;
	}

	@Then("the {string} is logged in")
	public void the_is_logged_in(String string) {
		int index = 0;
		if (string.equals("Admin"))
			index = 0;
		else if (string.equals("Secretary"))
			index = 1;
		else if (string.equals("Doctor"))
			index = 2;
		else if (string.equals("Patient"))
			index = 3;

		assertEquals(true, users.get(index).login(name, pass));
	}

	@Then("proceed to {string} activities menu")
	public void proceed_to_activities_menu(String string) {
		System.out.println("Welcome " + name + "! (" + string + ")");
	}

	@Then("the {string} is not logged in")
	public void the_is_logged_not(String string) {
		int index = 0;
		if (string.equals("Admin"))
			index = 0;
		else if (string.equals("Doctor"))
			index = 1;
		else if (string.equals("Patient"))
			index = 2;
		else if (string.equals("Secretary"))
			index = 3;

		assertEquals(false, users.get(index).login(name, pass));
	}

	@Then("{string} message will appear")
	public void message_will_appear(String string) {
		System.out.println(string);
	}

}
