Feature: login functionality


Background: 
Given use should be on login page



Scenario:TC_01_valid_login
When user enter the valid credentials
Then user should navigated to home page 
And user can see the logout link 

@esha
Scenario: TC_02_Invalid_login
When user enter the invalid credentials
Then user can see error message


Scenario Outline: TC_03_Invalid_login_data_driven
When user enter the invalid userid as "<userid>" and password as "<password>"
Then user can see error message
Examples: 
|userid     | password  |
|ad1		| pwd1		|
|ad2		| pwd2      |
|ad3 		| pwd3		|