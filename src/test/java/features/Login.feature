Feature: Login Functionality

  @smoke @login @regression
  Scenario: Successfully login with valid credentials
    Given The User is on the Login page
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage

  @smoke @login @regression
  Scenario Outline: Unsuccessful login with invalid credentials
    Given The User is on the Login page
    When The User enters an invalid username "<username>" and password "<password>"
    And The User clicks the login button
    Then An error message should be displayed

    Examples:
      | username     | password     |
      | invalidUser  | invalidPass  |
      | testUser     | wrongPass    |