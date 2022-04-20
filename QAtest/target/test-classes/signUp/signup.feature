Feature: Sign Up with google
  User should be able to sign up with google

  Scenario: Click Sign Up button
    Given User on the welcome page
    When User click on Sign up
    And User click Register with google
    And Pop up will show up
    And User fill email field
    And User click next button
    And User fill password field
    And User click next button
    And User will see register form
    And User click register button
		Then User should see homepage
    