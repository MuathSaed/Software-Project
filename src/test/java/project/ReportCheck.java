package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class ReportCheck {


	Secretary secretary;
	Clinic clinic = new Clinic();
	Report report = new Report();
	String date;
	
	ArrayList<Services> services = new ArrayList<Services>();
	
	public ReportCheck() {
		services.add(new Services("Colgate Electric Toothbrush ", 50, 35.00));
		services.add(new Services("Panadol Painkiller", 20, 20.00));
		services.add(new Services("Colgate Toothpaste", 0, 15.00));
		
		secretary = new Secretary("Muath", "muathpass", "Secretary");
		secretary.login("Muath", "muathpass");

	}
	
	@When("the secretary is logged in")
	public void theSecretaryIsLoggedIn() {
		assertEquals(true, secretary.loginStatus);
	}

	@When("and he\\/she want to check the number of available services")
	public void and_he_she_want_to_check_the_number_of_available_services() {

	}

	@When("he\\/she choose services list")
	public void he_she_choose_services_list() {

	}
	
	@When("click on button {string}")
	public void clickOnButton(String string) {
	    
	}
	
	@Then("a report of available services will be generated")
	public void a_report_of_available_services_will_be_generated() {
	    assertTrue(report.availableServicesReport(services));
	}



}
