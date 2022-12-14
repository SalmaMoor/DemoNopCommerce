@smoke
Feature: F04_Search | user could search for product
  #First Scenario:
  Scenario Outline: user could search using product name
    Given user writes product as "<product>"
    When user clicks on search button
    #Expected result
    Then list of products appear

    Examples:
    |product|
    |book|
    |laptop|
    |nike|

  #Second Scenario:
  Scenario Outline: user could search using product sku
    Given user writes product as "<productSerialNo>"
    When user clicks on search button
    #Expected result
    Then one product appears and user click on product

    Examples:
      |productSerialNo|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|
