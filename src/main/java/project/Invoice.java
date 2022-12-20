package project;

import java.util.*;
import java.util.logging.*;

public class Invoice {
	protected List<Services> services = new ArrayList<>();
	protected Double doctorVisit = 0.0;
	protected Double total = 0.0;

	public Invoice(List<Services> selectedServices, Double doctorVisit) {
		services = selectedServices;
		for (Services Services : selectedServices) {
			this.total += Services.getPrice();
		}
		this.doctorVisit = doctorVisit;
		this.total += doctorVisit;
	}

	public boolean printInvoice() {
		Logger logger = Logger.getLogger(Invoice.class.getName());
		if (total == 0.0)
			return false;
		String strServices;
		for (Services service : services) {
			strServices = service.toString();
			logger.log(Level.INFO, strServices);
		}
		String doctor = "Doctor visit = " + doctorVisit;
		String totalV = "Total Invoice = " + total + " NIS";

		logger.log(Level.SEVERE, "\n");
		logger.log(Level.INFO, doctor);
		logger.log(Level.INFO, "\n");
		logger.log(Level.INFO, totalV);

		return true;

	}
}
