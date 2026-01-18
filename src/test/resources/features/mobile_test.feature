Feature: Mobile App Automation

  Background:
    Given the Frisby Colombia app is launched

  Scenario Outline: User logs in
    Given the user is on the login screen
    When the user enters <username> and <password>
    Then the user should be logged in

    Examples:
      | username | password |
      | user1    | pass1    |
      | user2    | pass2    |
      | user2    | pass2    |