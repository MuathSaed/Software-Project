package project;

import io.cucumber.java.en.*;
import static org.junit.Assert.assertEquals;

public class VisitTest {
	Doctor doctor;
	Secretary secretary;
	Patient patient, patient2;
	Clinic record = new Clinic();
	int i = -1;

	public VisitTest() {
		doctor = new Doctor("Abod", "abodpass", "Doctor");
		doctor.login("Abod", "abodpass");
		secretary = new Secretary("Muath", "muathpass", "Secretary");
		secretary.login("Muath", "muathpass");
		patient = new Patient("Ahmad", "ahmadpass", "Patient");
		record.addAppointment(new Appointment("27/06/2022", "11"), patient);
	}

	@Given("the Secretary is logged in")
	public void theSecretaryIsLoggedIn() {
		assertEquals(secretary.loginStatus, true);
	}

	@When("a Patient arrived to clinic")
	public void aPatientArrivedToClinic() {
	}

	@When("the Patient has an appointment")
	public void thePatientHasAnAppointment() {
		i = record.getIndex(patient);
		assertEquals((i != -1), true);
	}

	@Then("the Secretary will record a visit")
	public void theSecretaryWillRecordAVisit() {
		if (i > -1)
			assertEquals(record.addVisit(record.appointmentsRecord.get(i)), true);
		else {
			record.addAppointment(new Appointment("22/07/2022", "11"), patient2);
			i = record.appointmentsRecord.size() - 1;
			assertEquals(record.addVisit(record.appointmentsRecord.get(i)), true);
		}
	}

	@When("the Patient does not have an appointment")
	public void thePatientDoesNotHaveAnAppointment() {
		i = record.getIndex(patient2);
		assertEquals((i != -1), false);
	}

	@When("the Doctor is available")
	public void theDoctorIsAvailable() {
		doctor.isAvailable = true;
		assertEquals(doctor.isAvailable, true);
	}

	@When("the Doctor is busy")
	public void theDoctorIsBusy() {
		assertEquals(doctor.isAvailable, false);
	}

	@Then("the Secretary will record and add an appointment for the Patient in another time")
	public void theSecretaryWillRecordAndAddAnAppointmentForThePatientInAnotherTime() {
		if (doctor.isAvailable)
			assertEquals(record.addAppointment(new Appointment("22/07/2022", "11"), patient2), true);
	}

}
