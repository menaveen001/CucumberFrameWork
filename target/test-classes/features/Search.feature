Feature: Search functionality

Scenario: User searches for a valid product
Given User is Open the Application
When User enters valid product "HP" into Search box fields
And User clicks on Search button
Then User should get valid product displayed in search  results

Scenario: User searches for an invalid product
Given User is Open the Application
When User enters invalid product "Honda" into Search box field
And User clicks on Search button
Then User should get a message about product matching
