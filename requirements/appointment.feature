Feature: add appointment 

Scenario Outline: Successfully added an appointment 
	Given the Patient is logged in 
	When the Patient select add appointment option 
	And the Patient chooses date of the appointment in <DD>/<MM>/<YYYY> format 
	And the Patient chooses time of the appointment 
	Then appointment will be added and booked 
	And "Appointment added successfully." message will appear 
	Examples: 
		|DD  |MM  |YYYY  |Time|
		|20  |10  |2022  |"9-10"|
		
Scenario Outline: Failed to add appointment 
	Given the Patient is logged in 
	When the Patient select add appointment option 
	And the Patient chooses date of the appointment in <DD>/<MM>/<YYYY> format 
	And the Patient chooses time of the appointment 
	But selected date and time are reserved by another Patient 
	Then appointment will not be added 
	And "Selected date and time are reserved by another patient." message will appear 
	Examples: 
		|DD  |MM  |YYYY  |Time|
		|14  |11  |2022  |"1-2"|
