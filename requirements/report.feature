Feature: report 

Scenario: Generate a medical report 
	Given The Doctor is logged in 
	When the Patient has finished his medical examination 
	Then the Doctor enters the results of the medical examination into the system 
	And the Doctor select Generete Report option 
	Then a report will be generated 
	
Scenario: Generate a report on available services 
	Given the Secretary is logged in 
	When the Secretary want to generate a report on available services 
	And the Secretary select Display Services option 
	And the Secretary select Generete Report option 
	Then a report will be generated 
 