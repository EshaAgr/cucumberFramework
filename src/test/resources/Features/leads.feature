Feature: login functionality

Background: 
Given use should be on login page
When user enter the valid credentials

@esha
Scenario: TC_04_create_lead
When user fill mandatory fields as "<lname>" and "<comp>"
|lname      | comp   |
|Sumit		| Esha	 |

Then lead should be created successfully
And click on logout
