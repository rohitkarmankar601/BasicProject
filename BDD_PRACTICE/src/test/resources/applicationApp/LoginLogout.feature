Feature:  Login & Logout Functionality

Scenario: Validate Login & Logout Functionality Of Application
Given     User Is At Login Page Of Application
When      User Enter The Username As "demo"
And       User Enter The Password As "demo"
And       User Click On 1 Login button 
Then      User Should Redirect To "Dashboard" Page 
And       Notification Icon Should Be Visible  
When      User Click On Logout button
Then      User Should Redirect to "Administration" Page


