Feature: invoice 

Scenario: Issuing an invoice after the Patient's visit to the Doctor 
	Given The Secretary is logged in 
	When the Patient has finished his medical examination 
	And the Secretary select Issue Invoice option 
	Then an invoice will be issued for the amount due from the Patient 
	
Scenario: Issuing an invoice after the Patient purchases services 
	Given The Secretary is logged in 
	When the Patient purchases a service from the Services List
	And the Secretary adds the service price to the invoice 
	And the Secretary select Issue Invoice option 
	Then an invoice will be issued for the amount due from the Patient 
