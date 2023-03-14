Feature: Login to Salesforce Application
Background: 
Given user open salesforce application
 

Scenario: login with valid user and empty password

When user on "LoginPage"
When  user enter value into text box username as "yj@tekarch.com"
When user click on login button
Then verify error message as "Please enter your password."


Scenario: login with valid user and valid password

When user on "LoginPage"
When  user enter value into text box username as "yj@tekarch.com"
When  user enter value into text box password as "user1234"
When user click on login button
When user on "HomePage"
Then verify pagetitle as "Home Page ~ Salesforce - Developer Edition"

Scenario: check remember me button in loginPage

When user on "LoginPage"
When  user enter value into text box username as "yj@tekarch.com"
When  user enter value into text box password as "user1234"
When user click on remember me button
When user click on login button
When user on "HomePage"
When user click on LoggedinUser dropdown
When user click on logout button
When user on "LoginPage"
Then verify username in username field is "yj@tekarch.com"


Scenario: check forgetPassword in loginpage

When user on "LoginPage"
When user click on ForgetPassword link
When user on "ForgetPasswordPage"
When  user enter value into text box username in forget password page as "yj@tekarch.com"
When user click on continue button
Then verify pagetitle as "Check Your Email | Salesforce"

Scenario: login with invalid user and invalid password

When user on "LoginPage"
When  user enter value into text box username as "abc@gmail.com"
When  user enter value into text box password as "1234"
When user click on login button
Then verify error message as "Please check your username and password. If you still can't log in, contact your Salesforce administrator."


