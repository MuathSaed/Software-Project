Feature: service

Scenario: the service is available 
	Given the patinet is logged in 
	And the patinet want to select a service 
	When the patient select a service "1"
	And the service is available 
	Then the service price will be added to the invoice 
	And message displayed "Service added successfully" 

		
Scenario: the service is not available 
	Given the patinet is logged in 
	And the patinet want to select a service 
	When the patient select a service "2"
	And the service is not available 
	Then message displayed "This service is not available" 
