package project;

import java.util.*;

public class Patient extends User {
	private List<Services> services = new ArrayList<>();
	private double doctorFee;
	
	public Patient(String name, String pass, String role) {
		super(name, pass, role);
	}
	
	public List<Services> getServices() {
		return services;
	}

	public boolean setServices(List<Services> services) {
		if (services.isEmpty())
			return false;

		this.services = services;
		return true;
	}


	public double getDoctorFee() {
		return doctorFee;
	}

	public void setDoctorFee(double doctorVisit) {
		this.doctorFee = doctorVisit;
	}

}
