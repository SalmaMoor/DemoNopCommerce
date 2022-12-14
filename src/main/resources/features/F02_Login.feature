@smoke
Feature: F02_Login | users could use login functionality to use their accounts
  #First Scenario:
  Scenario: user could login with valid email and password
  Given user go to login page
  And user login with "valid" "tester@example.com" and "P@ssw0rd"
  When user press on login button
    #Expected result
  Then user login to the system successfully

  #Second Scenario:
  Scenario: user could not login with invalid email and password
  Given user go to login page
  And user login with "invalid" "wrong@example.com" and "P@ssw0rd"
  When user press on login button
    #Expected result
  Then user could not login to the system
