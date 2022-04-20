Feature: Login with email
  User should be able to login with google

  Scenario: Click login button to login with email
    Given User on the welcome page to login
    When User click on login button
    And User fill email field in login page
    And User fill password field in login page
    And User click login button
		Then User should see the homepage
    