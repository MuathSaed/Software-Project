package project;

import java.util.*;
import java.util.logging.*;

public class Report {
	public boolean numOfVisitsReport(int numOfVisits, String month) {
		if (numOfVisits == 0)
			return false;
		Logger logger = Logger.getLogger(Invoice.class.getName());
		String nummonth = "Number of visits for month " + month + " = " + numOfVisits;
		logger.log(Level.INFO, nummonth);
		return true;
	}

	public boolean availableServicesReport(List<Services> availableServices) {

		if (availableServices.isEmpty())
			return false;
		Logger logger = Logger.getLogger(Invoice.class.getName());

		String ser;

		for (Services service : availableServices) {
			ser = service.printList();
			logger.log(Level.INFO, ser);

		}
		return true;
	}

}
