Feature: Positive login

Scenario: Login as a host
        Given I am on the FourStay home page
        When I login as a host
        Then I should be able to verify I am logged in 
       
Scenario: Login as a guest
       Given I am on the FourStay home page
       When I login as a guest
       Then I should be able to verify I am logged in
