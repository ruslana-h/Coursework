Feature: User is able to login

  @login @regression @smoke
  Scenario Outline: User login with valid credentials
    Given User navigates to login page
    When User set field value "<userName>" on login page
    And User enter field value "<password>" on login page
    And User clicks on the "Login" button
    Then Error message is not displayed on the login page
    Examples:
      | userName | password |
      | admin    | admin    |
      | ADMIN    | admin    |