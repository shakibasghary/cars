@sampletest
Feature: Search Button

Background: Search Criteria Preconditions
Given user is on home page
When user select below criteria
|StockType|Make|Model|Price|MilesFrom|ZipCode|
|Used Cars|Honda|Pilot|50000|100|6008|
And user clicks on Search button 
Then user should see filtered list based on criteria

Scenario: Validate that user is able to modify search criteria 
 
When user selects New radio button from New/Used
And user selects 'Touring 8-Passenger' from Trim
And user clicks on second available car
And user fills out the contact seller section with below information
|FirstName|LastName|Email|
|Car|Owner|carowner@yahoo.com|
Then user should scroll down to 'Payment Calculator'