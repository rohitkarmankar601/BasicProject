Feature: Edit User Profile

Scenario: Edit User Profile From Profile Page
Given     User Is At Login Page
When      User Enter Username As "demo"
And       User Enter Password As "demo"
And       User Click On Login button 
Then      User Should Redirect To "Dashboard" Page
When      User Click On demo_demo Dropdown button
Then      DropDown Should Be Display
When      User Click On "Your Profile" button From Dropdown
Then      User Should Redirect To "Profile" Page2
When      User Enter Following Data
          |Username|Firstname|Lastname|Email|password|confirmPassword| 
          |rohitkar|rohit|karmankar|rohitkarmankar327@gmail.com|roru@123|roru@123|
And       User Upload The Image
And       User Click On Save button           
Then      Error Message As " Warning: You do not have permission to modify your profile! " Should Display




