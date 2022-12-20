package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class InvoiceCheck {

	Patient patient;
	Secretary secretary;
	int index;
	boolean available;
	Invoice invoice;

	public InvoiceCheck() {
		
		patient = new Patient("Ahmad", "ahmadpass", "Patient");
		patient.login("Ahmad", "ahmadpass");
		secretary = new Secretary("Muath", "muathpass", "Secretary");
		secretary.login("Muath", "muathpass");
		patient.getServices().add(new Services("Panadol Painkiller", 20, 20.00));
	}
	
	@When("the patinet finished his visit")
	public void the_patinet_finished_his_visit() {
		patient.setDoctorFee(50.00);
	    invoice = new Invoice(patient.getServices(), patient.getDoctorFee());
	}

	@Then("the secretary will issue the invoice")
	public void the_secretary_will_issue_the_invoice() {
	    assertTrue(invoice.printInvoice());
	    invoice.total = 0.0;
	    assertEquals(false, invoice.printInvoice());
	}


}
