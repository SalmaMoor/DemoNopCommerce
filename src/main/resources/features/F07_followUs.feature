@smoke
Feature: F07_followUs | users could open follow Us links

  #First Scenario:
  Scenario: user opens facebook link
  When user clicks on facebook link
  Then facebook link will be opened in new tab

  #Second Scenario:
  Scenario: user opens twitter link
  When user clicks on twitter link
    #Expected result
  Then twitter link will be opened in new tab

  #Third Scenario:
  Scenario: user opens rss link
  When user clicks on rss link
    #Expected result
  Then rss link will be opened in new tab

  #Fourth Scenario
  Scenario: user opens youtube link
  When user clicks on youtube link
    #Expected result
  Then youtube link will be opened in new tab