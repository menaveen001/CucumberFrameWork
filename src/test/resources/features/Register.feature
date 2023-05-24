Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account Page
When User enters the detalis into below fields
|firstName|Naveen|
|lastName|Pal|
|email|naveen@gamil.com|
|telephone|123456789|
|password|12345|
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfull

Scenario: User creates an account  with all mandatory fields
Given User navigates to Register Account Page
When User enters the detalis into below fields
|firstName|Naveen|
|lastName|Pal|
|email|naveen@gamil.com|
|telephone|123456789|
|password|12345|
And User selects yes Newslatter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfull

Scenario: User creates a duplicate account 
Given User navigates to Register Account Page
When User enters the detalis into below fields to create duplicate account
|firstName|Naveen|
|lastName|Pal|
|email|navi@gamil.com|
|telephone|123456789|
|password|12345|
And User selects yes Newslatter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account Page
When User dont enters any deatils into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field 

