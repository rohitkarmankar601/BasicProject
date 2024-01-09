Feature: Validate Zoho Cloud Software Suite for Businesses & SignIn Page Of Zoho

Scenario: Validate Title & URL Of Zoho Cloud Software Suite for Businesse Page
Given     User Is At Zoho Cloud Software Suite for Businesse Page
Then      Title Should Be "Zoho | Cloud Software Suite for Businesses"
And       URL Should Be "https://www.zoho.com/"

Scenario: Validate SignIn Page Of Zoho
Given     User Is At Zoho Cloud Software Suite for Businesse Page
When      User Click On SignIn Page 
Then      User Should redirect to "Create New Account - zoho.com" Page
When      User Enters The Following Deatils
          |Email|Password|PhoneNumber|
          |rohitkarmankar11@gmail.com|Rohit@1998|7498927070|
          |rohitkarmankar327@gmail.com|Mohit@1998|7218147520|
          |rohitkarmankar7@gmail.com|Kohit@1998|9218147520|
And       User Check The Aggrement 
And       User Click On Sign Up For Free button  
Then      Confirmation Message As "Please enter the CAPTCHA." Should Visible.       
 
    