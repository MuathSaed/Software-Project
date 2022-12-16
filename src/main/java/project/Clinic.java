package project;

import java.util.ArrayList;
import java.util.logging.*;

public class Clinic {
	protected ArrayList<Appointment> appointmentsRecord = new ArrayList<>();
	protected ArrayList<Patient> patientsList = new ArrayList<>();
	protected ArrayList<Integer> reservationType = new ArrayList<>();
	Logger logger = Logger.getLogger(Clinic.class.getName());


	public boolean addAppointment(Appointment appointment, Patient patient) {
		if (isAvailable(appointment)) {
			appointmentsRecord.add(appointment);
			patientsList.add(patient);
			reservationType.add(1);
			return true;
		}

		return false;
	}

	public boolean addVisit(Appointment appointment) {
		int index = getIndex(appointment);
		if (index >= 0) {
			reservationType.set(index, 2);
			return true;
		}

		return false;
	}

	public boolean isAvailable(Appointment appointment) {
		for (Appointment appointmentX : appointmentsRecord) {
			if (appointmentX.date.equals(appointment.date) && appointmentX.time.equals(appointment.time)) {
				return false;
			}
		}
		return true;
	}

	public Integer getIndex(Appointment appointment) {
		Integer index = 0;
		for (Appointment appointmentX : appointmentsRecord) {
			if (appointmentX.date.equals(appointment.date) && appointmentX.time.equals(appointment.time)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	public Integer getIndex(Patient patient) {
		Integer index = 0;
		for (Patient patientX : patientsList) {
			if (patientX.equals(patient)) {
				return index;
			}
			index++;
		}

		return -1;
	}

	public boolean deleteAppointment(Appointment appointment) {
		int index = getIndex(appointment);
		if (index >= 0) {
			appointmentsRecord.remove(index);
			patientsList.remove(index);
			reservationType.remove(index);
			return true;
		}

		return false;

	}

	public boolean editAppointment(Appointment old, Appointment appointment) {

		if (isAvailable(appointment)) {
			int index = getIndex(old);
			if (index >= 0) {
				appointmentsRecord.set(index, appointment);
				return true;
			}
		}

		return false;
	}

	public void printForPatient(Patient patient) {
		for (int i = 0; i <= patientsList.size(); i++) {
			if (patientsList.get(i).equals(patient) && reservationType.get(i).equals(1)) {
				logger.log(Level.INFO, (i + 1) + ".   Date: " + appointmentsRecord.get(i).date + "   Time: "
						+ appointmentsRecord.get(i).time);
			}
		}
	}

}
