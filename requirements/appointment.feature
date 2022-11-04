Feature: manage appointment 

Scenario Outline: the Patient has successfully added an appointment 
	Given the Patient is logged in 
	When the Patient select add appointment option 
	And the Patient chooses <Date> of the appointment in DD/MM/YYYY format 
	And the Patient chooses <Time> of the appointment 
	Then appointment will be added and recorded 
	And "Appointment added successfully." message will appear 
	Examples: 
		|Date	  		|Time|
		|"20/10/2022"  	|"9"| 
		
Scenario Outline: the Patient failed to add appointment 
	Given the Patient is logged in 
	When the Patient select add appointment option 
	And the Patient chooses <Date> of the appointment in DD/MM/YYYY format 
	And the Patient chooses <Time> of the appointment 
	But selected date and time are reserved by another Patient 
	Then appointment will not be added 
	And "Selected date and time are reserved by another patient." message will appear 
	Examples: 
		|Date	  		|Time|
		|"14/11/2022"  	|"2"|		
		
Scenario Outline: the Patient has successfully changed his appointment 
	Given the Patient is logged in 
	When the Patient select change appointment option 
	And the Patient selects the appointment he wants to change "1" 
	And the Patient chooses a new <Date> of the appointment in DD/MM/YYYY format 
	And the Patient chooses a new <Time> of the appointment 
	Then appointment will be edited and recorded 
	And "Appointment has been changed successfully." message will appear 
	Examples: 
		|Date	  		|Time|
		|"18/12/2022"  	|"3"|
		
Scenario Outline: the Patient failed to change his appointment 
	Given the Patient is logged in 
	When the Patient select change appointment option 
	And the Patient selects the appointment he wants to change "1" 
	And the Patient chooses a new <Date> of the appointment in DD/MM/YYYY format 
	And the Patient chooses a new <Time> of the appointment 
	But selected date and time are reserved by another Patient 
	Then appointment will not be changed 
	And "Selected date and time are reserved by another patient." message will appear 
	Examples: 
		|Date	  		|Time|
		|"14/11/2022"  	|"2"| 
		
Scenario: the Patient has successfully deleted his appointment 
	Given the Patient is logged in 
	When the Patient select delete appointment option 
	And the Patient selects the appointment he wants to delete "1" 
	Then appointment will be deleted 
	And "Appointment has been deleted successfully." message will appear 
	
	