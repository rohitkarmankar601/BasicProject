Feature: Login Functionality

Background: Validate Login Page Of Application
Given       User Is At Login Page
Then        Title Of Page Should Be "Administration"
And         Url Of Page Should Be "https://demo.opencart.com/admin/index.php"

Scenario Outline: Login With Valid Credentials
Given User Is At Login Page
When  User Enter Username As "<username>"
And   User Enter Password As "<password>" 
And   User Click On 1 Login button 
Then  User Should Redirect To "Dashboard" Page
Examples:
|username|password|
| demo   | demo   |
| demo   | demo   |
| demo   | demo   |



