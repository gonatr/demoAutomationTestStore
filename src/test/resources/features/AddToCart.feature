@TestItems
  Feature: Add Item on chart
    Background:
      Given User on Page Automation Test Store
      And User click sign
      When User Input set username test_user_wsb, set password test_pass_wsb click login btn

    Scenario: Successfully add items to chart
      When User click Apparel & accessories
      And User click Shooes
      And User choose product Items
      And User set Size, Colour, QTY and click add to chart button
      And User confirm Item click checkout
      Then User get the result Items