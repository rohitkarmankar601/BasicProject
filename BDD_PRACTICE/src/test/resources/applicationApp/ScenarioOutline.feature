Feature: Verify Login Functionality Of OrangeHrm

Background: Validate Title & URL Of Login Page
Given User Is At Login Page Of OrageHrm
Then  URL Of LoginPage Should Be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
And   Title Of LoginPage Should Be "OrangeHRM"

@function
Scenario Outline: Validate Login Functionality By Passing Valid Credentials
Given User Is At Login Page Of OrageHrm
When  User enter The Username As "<Username>"
And   User enter The Password As "<password>"
And   User click On <ButtonNumber> Login button
Then  User Should redirect To "Dashboard" Page
Examples:
|Username|password|ButtonNumber|
|Admin   |admin123|   1        |
|Admin   |admin123|   1        |
|Admin   |admin123|   1        |

@regression
Scenario Outline: Validate Login Functionality By Passing InvalidValid Credentials
Given User Is At Login Page Of OrageHrm
When  User enter The username As "<username>"
And   User enter The password As "<Password>"
And   User click On <ButtonNumber> login button
Then  Error Message "Invalid credentials" Should Display
Examples:
|username|Password|ButtonNumber|
|MANGO   |admi123 |   1        |
|AdHin   |adOin123|   1        |
|AdmiO   |admiI123|   1        |