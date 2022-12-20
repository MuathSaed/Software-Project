package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class ServiceCheck {
	Patient patient;
	int index;
	boolean available;
	ArrayList<Services> services = new ArrayList<>();
	ArrayList<Services> addedServices = new ArrayList<>();

	public ServiceCheck() {
		Services service1 = new Services("Colgate Electric Toothbrush ", 50, 35.00);
		services.add(service1);
		services.add(new Services("Panadol Painkiller", 20, 20.00));
		services.add(new Services("Colgate Toothpaste", 0, 15.00));
		patient = new Patient("Ahmad", "ahmadpass", "Patient");
		patient.login("Ahmad", "ahmadpass");
	}

	@Given("the patinet is logged in")
	public void the_patinet_is_logged_in() {
		assertTrue(patient.loginStatus);
	}

	@Given("the patinet want to select a service")
	public void the_patinet_want_to_select_a_service() {
		int i = 1;
		for (Services service : services) {
			System.out.println(i++ + ". " + service);
		}
	}

	@When("the patient select a service {string}")
	public void the_patient_select_a_service(String string) {
		index = Integer.parseInt(string);
		System.out.println(index);
	}

	@When("the service is available")
	public void the_service_is_available() {
		available = services.get(index).getQuantity() != 0;
		assertTrue(available);
	}

	@Then("the service price will be added to the invoice")
	public void the_service_price_will_be_added_to_the_invoice() {
		if (available) {
			services.get(index).removeQuantity();
			addedServices.add(services.get(index));
			assertTrue(patient.setServices(addedServices));
		}
	}

	@Then("message displayed {string}")
	public void message_displayed(String string) {
		System.out.println(string);
	}

	@When("the service is not available")
	public void the_service_is_not_available() {
		available = services.get(index).getQuantity() != 0;
		assertFalse(available);
	}

}
