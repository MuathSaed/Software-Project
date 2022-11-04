Feature: user login 

Scenario Outline: <role> has successfully logged in 
	Given That the <role> on the homepage 
	And the <role> user name is <name> 
	And the <role> password is <password> 
	Then the <role> is logged in 
	And proceed to <role> activities menu 
	Examples: Users Table 
		|name       |password    	|role|
		|"Haya"     |"hayapass"		|"Admin" |
		|"Muath"    |"muathpass"    |"Secretary"|
		|"Abod"     |"abodpass"  	|"Doctor"|
		|"Ahmad"    |"ahmadpass"   	|"Patient"|
		
Scenario Outline: <role> failed to login due to wrong username 
	Given That the <role> on the homepage 
	And the <role> user name is <name> 
	Then the <role> is not logged in 
	And "This user is not registered in the system" message will appear 
	Examples: Users Table 
		|name        |password    	|role|
		|"Haya@"     |"hayapass"	|"Admin" |
		|"Muath@"    |"muathpass"   |"Secretary"|
		|"Abod@"     |"abodpass"  	|"Doctor"|
		|"Ahmad@"    |"ahmadpass"  	|"Patient"|
		
Scenario Outline: <role> failed to login due to wrong password 
	Given That the <role> on the homepage 
	And the <role> user name is <name> 
	And the <role> password is <password> 
	Then the <role> is not logged in 
	And "The password for this user is incorrect" message will appear 
	Examples: Users Table 
		|name       |password    	|role|
		|"Haya"     |"hayapass@"	|"Admin" |
		|"Muath"    |"muathpass@"   |"Secretary"|
		|"Abod"     |"abodpass@"  	|"Doctor"|
		|"Ahmad"    |"ahmadpass@"  	|"Patient"|
	