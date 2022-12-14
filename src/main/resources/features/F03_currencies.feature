@smoke
Feature: F03_Currencies | users could select currency
  #Test Scenario:
  Scenario: user could select currency
    When Select Euro currency from the dropdown list on the top left of home page

    #Expected result
    Then Euro Symbol (€) is shown on the four products displayed in Home page