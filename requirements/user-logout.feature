Feature: user logout 

Scenario Outline: the <role> logged out 
	Given that the <role> is logged in 
	When the <role> logs out 
	Then the <role> is not logged in 
	Examples: Users Table 
		|name       |password    	|role|
		|"Haya"     |"hayapass"		|"Admin" |
		|"Muath"    |"muathpass"    |"Secretary"|
		|"Abod"     |"abodpass"  	|"Doctor"|
		|"Ahmad"    |"ahmadpass"   	|"Patient"|
		