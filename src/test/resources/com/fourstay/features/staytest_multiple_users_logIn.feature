Feature: User account information



Scenario: Verify user account information
    Given the user is on the FourStay homepage
    And   the user sings in using "sking@testmail.com" and "password"
    And   the user goes to the user general setting page
    Then  the user full name should be "Steven" "King"
    And   the user phone number should be "5151234567"
    And   the user email should be "sking@testmail.com"
    
 
Scenario Outline: Verify user account information
    Given the user is on the FourStay homepage
    And   the user sings in using "<email>" and "<password>"
    And   the user goes to the user general setting page
    Then  the user full name should be "<first name>" "<last name>"
    And   the user phone number should be "<phone number>"
    And   the user email should be "<email>"   
    
    Examples:
        |first name| last name   | email                 | phone number |password|
        |Steven    | King        | sking@testmail.com    | 5151234567   |password|
		|Diana     | Lorentz     | dlorentz@testmail.com | 5904235567   |password|
		|David     | Austin      | daustin@testmail.com  | 5904234569   |password|
		|Ismael    | Sciarra     | isciarra@testmail.com | 5151244369   |password|
		|Irene     | Mikkilineni | imikkili@testmail.com | 6501241224   |password|
		|Julia     | Nayer       | jnayer@testmail.com   | 6501241214   |password|
		|Shelley   | Higgins  	 | shiggins@testmail.com | 5151238080   |password|
		|Anthony   | Cabrio      | acabrio@testmail.com  | 6505094876   |password|
		|Randall   | Perkins     | rperkins@testmail.com | 6505054876   |password|
		|Donald    | Oconnell    | doconnel@testmail.com | 6505079833   |password|
	
		
@Logintest  		
Scenario: Verify user account information using model 
	Given the user is on the FourStay homepage 
	When  the user sings in using "sking@testmail.com" and "password" information
	Then  general settings page should have the correct personal information 
		 |first name | last name | phone number   |  email             | host  |
		 |Steven     |King       |5151234567      | sking@testmail.com | false | 
		 
		
		
		
		
		
		
		
		
    