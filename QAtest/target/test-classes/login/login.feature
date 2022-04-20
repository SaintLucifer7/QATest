Feature: Login with Google
  User should be able to login with google

  Scenario: Click login button
    Given User on the welcome pagee
    When User click on login
    And User click log in with google
    And Pop up will show upp
    And User fill login email field
    And User click login next button
    And User fill password login field
    And User click login next button
		Then User should see homepagee
    