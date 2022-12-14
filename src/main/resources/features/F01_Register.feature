@smoke
Feature: F01_Register | users could register with new accounts
  #Test Scenario:
  Scenario: guest user could register with valid data successfully
    Given user go to register page

    And user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth
    And user enter email "tester@example.com" field
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    When user clicks on register button

    #Expected result
    Then success message is displayed
