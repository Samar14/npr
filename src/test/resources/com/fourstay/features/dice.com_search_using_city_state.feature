@Dice
Feature: User search using City and State

Scenario: Search using valid City and State and blank keyword
    Given User is on dice homepage
    When  User enters "Pittsburgh, PA" into location field 
    Then  User clicks on Find Tech Jobs
    Then  Search results should be displayed
  
   
Scenario: Search using valid City and State and keyword
	Given User is on dice homepage
	When  User searches for "Selenium Engineer" in "Pittsburgh, PA"
	Then  Search results should be displayed for the keyword
    
