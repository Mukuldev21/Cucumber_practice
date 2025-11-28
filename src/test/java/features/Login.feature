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

  Scenario: Successfully logout from the application
    Given The User is logged in with valid credentials
    When The User clicks the logout button
    Then The User should be redirected to the Login page

  Scenario: Login as locked out user
    Given The User is on the Login page
    When The User enters a locked out username and password
    And The User clicks the login button
    Then A locked out error message should be displayed

  Scenario: Login as a problem user
    Given The User is on the Login page
    When The User enters a problem user username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage with issues