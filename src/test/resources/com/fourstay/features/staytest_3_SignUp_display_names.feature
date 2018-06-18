@Signup 
Feature: Display names properly for new users

Scenario: Verify full names for hosts
    Given the user is on the FourStay sign up dialog
    And   the user enters enter first name "John" and last name "Smith"
    And   the user enters any unregistered email and password 
    When  the user click on the Sign up button
    Then  first name "asasasasas" and last name "Smith" should be displayed on account details page
    
   
Scenario: Verify full names for guest
   Given the user is on the FourStay sign up dialog 
   And   the user enters enter first name "Jim" and last name "Smith" 
   And   the user clicks the guest radiobutton
   And   the user enters any unregistered email and password 
   When  the user click on the Sign up button
   Then first name "Jim" and last name "Smith" should be displayed on account details page