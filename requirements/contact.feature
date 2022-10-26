Feature: contact 

Scenario: Postponement of appointment due to Doctor's busy 
	Given The Secretary is logged in 
	When the Doctor is busy 
	Then the Secretary select Patient Info option 
	And the Secretary get Patient contact number 
	Then the Secretary will call the Patient to postpone the appointment 
	And the Secretary will add and record a new appointment 
	
Scenario: Cancellation of appointment due to unavailability of Doctor 
	Given The Secretary is logged in 
	When the Doctor is not available 
	Then the Secretary select Patient Info option 
	And the Secretary get Patient contact number 
	Then the Secretary will call the Patient to cancel the appointment