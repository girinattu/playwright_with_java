@test1
Feature: Automate selenium page
  A test to open the selenium page using playwright in java and cucumber

  Scenario: Open Selenium Webdriver documentation
    Given the user is on selenium.dev page
    When the user clicks on Read More link
    Then the webdriver documentation is opened

  Scenario: Open Getting started page
    Given the user is on selenium.dev page
    And the user clicks on Read More link
    When the user clicks on getting_started link
    Then the user is presented with the 'Getting Started' page

