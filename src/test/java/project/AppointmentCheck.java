package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class AppointmentCheck {

	String date, time;
	Patient patient;
	Appointment appointment, selected;
	Clinic record = new Clinic();
	int i;

	public AppointmentCheck() {
		patient = new Patient("Ahmad", "ahmadpass", "Patient");
		patient.login("Ahmad", "ahmadpass");
		record.addAppointment(new Appointment("27/06/2022", "11"), patient);
		record.addAppointment(new Appointment("14/11/2022", "2"), patient);
	}

	@Given("the Patient is logged in")
	public void thePatientIsLoggedIn() {
		assertEquals(true, patient.loginStatus);
	}

	@When("the Patient select add appointment option")
	public void thePatientSelectAddAppointmentOption() {
	}

	@When("the Patient chooses {string} of the appointment in DD\\/MM\\/YYYY format")
	public void thePatientChoosesOfTheAppointmentInDDMMYYYYFormat(String string) {
		this.date = string;
	}

	@When("the Patient chooses {string} of the appointment")
	public void thePatientChoosesOfTheAppointment(String string) {
		this.time = string;
	}

	@Then("appointment will be added and recorded")
	public void appointmentWillBeAddedAndRecorded() {
		appointment = new Appointment(date, time);
		assertEquals(true, record.addAppointment(appointment, patient));
	}

	@When("selected date and time are reserved by another Patient")
	public void selectedDateAndTimeAreReservedByAnotherPatient() {
		appointment = new Appointment(date, time);
		assertEquals(false, record.isAvailable(appointment));
	}

	@Then("appointment will not be added")
	public void appointmentWillNotBeAdded() {
		assertEquals(false, record.addAppointment(appointment, patient));
	}

	@When("the Patient select change appointment option")
	public void thePatientSelectChangeAppointmentOption() {
	}

	@When("the Patient selects the appointment he wants to change {string}")
	public void thePatientSelectsTheAppointmentHeWantsToChange(String string) {
		i = Integer.parseInt(string) - 1;
		selected = record.appointmentsRecord.get(i);
	}

	@When("the Patient chooses a new {string} of the appointment in DD\\/MM\\/YYYY format")
	public void thePatientChoosesANewOfTheAppointmentInDDMMYYYYFormat(String string) {
		this.date = string;
	}

	@When("the Patient chooses a new {string} of the appointment")
	public void thePatientChoosesANewOfTheAppointment(String string) {
		this.time = string;
	}

	@Then("appointment will be edited and recorded")
	public void appointmentWillBeEditedAndRecorded() {
		appointment = new Appointment(date, time);
		assertEquals(true, record.editAppointment(selected, appointment));
	}

	@Then("appointment will not be changed")
	public void appointmentWillNotBeChanged() {
		appointment = new Appointment(date, time);
		assertEquals(false, record.editAppointment(selected, appointment));
	}

	@When("the Patient select delete appointment option")
	public void thePatientSelectDeleteAppointmentOption() {
	}

	@When("the Patient selects the appointment he wants to delete {string}")
	public void thePatientSelectsTheAppointmentHeWantsToDelete(String string) {
		i = Integer.parseInt(string) - 1;
		selected = record.appointmentsRecord.get(i);
	}

	@Then("appointment will be deleted")
	public void appointmentWillBeDeleted() {
		assertEquals(true, record.deleteAppointment(selected));
	}

}
