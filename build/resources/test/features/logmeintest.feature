Feature: Tests for www.seleniumeasy.com/test/

    Scenario: Verify page title
      Given I am on the homepage of seleniumeasy
      When I investigate the page title
      Then It should contain the string 'Selenium Easy'

    Scenario: Verify summation
      Given I am on the homepage of seleniumeasy
      When I open the 'Input Forms' dropdown in the menu
        And I choose 'Simple Form Demo' item
        And I enter 5 in the 'a' input field
        And I enter 6 in the 'b' input field
        And I click on the 'Get total' button
      Then the result should be '11'

    Scenario: Verify checkbox behavior
      Given I am on the homepage of seleniumeasy
      When I open the 'Input Forms' dropdown in the menu
        And I choose 'Checkbox Demo' item
        And I tick the single checkbox
      Then the successful result message is appeared

    Scenario: Verify form to submit logic
      Given I am on the homepage of seleniumeasy
      When I open the 'Input Forms' dropdown in the menu
        And I choose 'Ajax Form Submit' item
        And I attempt to submit the form
      Then the form is not submitted
      When I fill the 'Name' input field
        And I fill the 'Comment' input field
        And I attempt to submit the form
      Then the form is submitted