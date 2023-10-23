Feature: Login Scenarios.


Scenario: Login with valid username and password
Given User is on login page.
When User enters valid username "Admin" and password "admin123"
And User clicks on Login button.
Then Home page should be displayed

