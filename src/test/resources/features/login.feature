
Feature: Login

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    And the user clicks the login button
    Then the secure area should be displayed
