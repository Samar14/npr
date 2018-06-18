@Regression
Feature:  Signing up using Facebook and Google

Background:
     Given User on the FourStay home page
     When  User clicks on the SIGN IN link

@Facebook
Scenario:  Sign In using Facebook
     Then  the Sign in with Facebook option should be available
     
@Google   
Scenario:  Sign In using Google    
     Then  the Sign in with Google option should be available
     
           