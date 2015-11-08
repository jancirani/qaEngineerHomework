Feature: 'tak application'
  As a QA
  I want to write more cases for tax application
  So that I can cover more scenarious

  Scenario: Verify tax application window title
    Given application is running
    When window is open
    Then window title should be qatest

  Scenario: verify all elements are displayed on the application
    Given applicatioon is running
    When page is loaded succesfully
    Then it should contains Title with dropdown box, Name with text box and Salary with text box and Calculate tax button

  Scenario: verify error when entering non integer value in salary text box
    Given application is running
    When I enter non interger value in salary text box
    And perform click action on calculate tax button
    Then It should validate salary text box
    And an message should display accordingly

  Scenario: Values shoudl be reset when page/application is reloaded
    Given application is running
    And I filled all information
    When I referesh page or re-open application
    Then all fields should be re-set to default

  Scenario: submiting application without any entries in the fields
    Given application is up
    When I click on calculate tax button
    Then It should show an error message
