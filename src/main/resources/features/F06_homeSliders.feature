@smoke
  Feature: F06_homeSliders | user will click on one of two sliders at home page to navigate to product page
    First slider is Nokia Lumia 1020, Second slider is iPhone. And user may click one of them.
  #First Scenario
  Scenario: first slider is clicked on home page
    When user click on first slider
   #Expected result
    Then user will navigate to first slider product page

  #Second Scenario
  Scenario: second slider is clicked on home page
    When user click on second slider
   #Expected result
    Then user will navigate to second slider product page

