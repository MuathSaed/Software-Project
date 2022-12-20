Feature: report
	
Scenario: The secretary need to generate a report for the available services 
	When the secretary is logged in 
	And and he/she want to check the number of available services 
	And he/she choose services list 
	And click on button "Generate report" 
	Then a report of available services will be generated 
 