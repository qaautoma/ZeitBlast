Feature: Run Batch Functionality

  As a user of the Zeit Blast application
  I want to be able to log in with my account
  So that I can create a new batch
  
  Background:
    Given the user is on the login page of the application
		When the user logs in with the username "udaysi99@gmail.com" and password "Uday@9977"
    And  selects Remember Me
    And the user accepts terms and conditions
    And the user clicks on the login button
    Then the_user_is_on_Dashboard
    
  Scenario: User creates a new batch successfully
 		When the user selects the batch option
    And click on the create new batch option
    And select the campaign
    
    