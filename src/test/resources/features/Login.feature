@login

Feature: E-commerce Website - Login Page

  Scenario: Validate Successful Login
    Given I access the E-commerce Website login page
    When I enter an email "test@test.com"
    And I enter a password test123
    And I click on the Login button
    Then I should be presented with the Account button in the navbar

  Scenario: Validate Unsuccessful Login
    Given I access the E-commerce Website login page
    When I enter an email "test@test.com"
    And I enter a password pass123
    And I click on the Login button
    Then I should be presented with the invalid login credentials error message
