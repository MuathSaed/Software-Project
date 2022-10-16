Feature: visit 

Scenario: the Patinet arrived to the clinic on his appointment 
	Given the Secretary is logged in 
	When a Patient arrived to clinic 
	And the Patient has an appointment 
	Then the Secretary will record a visit 
	
Scenario: the Patinet arrived to the clinic without appointment and the Doctor is available 
	Given The Secretary is logged in 
	When a Patient arrived to clinic 
	But the Patient does not have an appointment 
	And the Doctor is available 
	Then the Secretary will record a visit 
	
Scenario: the Patinet arrived to the clinic without appointment and the Doctor is busy 
	Given The Secretary is logged in 
	When a Patient arrived to clinic 
	But the Patient does not have an appointment 
	And the Doctor is busy 
	Then the Secretary will record and add an appointment for the Patient in another time 
