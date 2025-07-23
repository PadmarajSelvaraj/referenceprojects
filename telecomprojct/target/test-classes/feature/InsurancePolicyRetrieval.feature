
Feature: User Login
  @qa
  Scenario: User logs in with valid credentials
    Given the following users exist:
      | username  | password   |
      | user1    | pass1      |
      | user2    | pass2      |
    When I log in as "user1" with password "pass1"
    Then I should see a welcome message for "user1"

  Scenario: User logs in with invalid credentials
    Given the following users exist:
      | username  | password   |
      | user1    | pass1      |
      | user2    | pass2      |
    When I log in as "user1" with password "wrongpass"
    Then I should see an error message for "user1"
