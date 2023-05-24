Feature: Login functionality

Scenario: Login with valid cerdentials
Given User has navigate to login page
When User has enters valid email address "navi12@gmail.com" into the email field
And User has enters valid password "12345" into password field
And User clicks on login button
Then User should get successfully loged in

Scenario: Login with invalid credentials
Given User has navigate to login page
When User has enters invalid email address "navi5@gmail.com" into the email field
And User has enters invalid password "1235" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User has navigate to login page
When User has enters valid email address "navi1@gmail.com" into the email field
And User has enters invalid password "1235" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invailid email and vailid password
Given User has navigate to login page
When User has enters invalid email address "navi5@gmail.com" into the email field
And User has enters valid password "12345" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentails
Given User has navigate to login page
When User dont enters email address into email field
And User dont enters Password into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch
