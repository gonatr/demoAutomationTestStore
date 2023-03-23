@TestLogin
Feature: login
  Background:
    Given User on Page Automation Test Store
    And User click sign

  @LoginValid @Positive
  Scenario: Successfully Login with Valid Credentials
    When User Input set username test_user_wsb, set password test_pass_wsb click login btn
    Then User get the result Resource

  @LoginInvalid @Negative
    Scenario Outline: Unsuccessfully login with Invalid Credentials
    When User input user <username>, pass <password> and click login btn
    Then User get the result Resource
    Examples:
      | username       | password      |
      | test_user_wsb  | 1234567       |
      |                | test_pass_wsb |
      | test_user_wsb  |               |
      | test_user_wsbk | 1234567       |