@all
Feature: 'UK tax calculator'
  
  As a QA Engineer
   I want to test a simplified UK tax allowance calculator based on below tax bands
   So that I can calculater income rates based on percentages

  Background: 'tax bands'
    
    All income up to £31,785 will be taxed at 20%
    All income between £31,786 and £150,000 will be taxed at 40%
    All income above £150,000 will be taxed at 45%


  @withMultipleTestData
  Scenario Outline: calculating tax payer based on rates
    Given tax application is running
    And I select a title<title>
    And I enter <name> with <salary>
    When I calculate tax
    Then it should show your calculated tax <taxAmount> with an message
    And a message contains title name <message>

    Examples: 
      | title  | name       | salary | taxAmount | message                             |
      | "Mr"   | "naresh"   | 10000  | 2000      | "Mr naresh, your tax is £2000"      |
      | "Miss" | "nataliia" | 50000  | 13643     | "Miss nataliia, your tax is £13643" |
      #Below scenario fails because on UI tax amount shown as £76142.6
      | "Mrs"  | "robert"   | 200000 | 76143     | "Mrs robert, your tax is £76143"    |
      | "Dr"   | "sam"      | 55000  | 15643     | "Dr sam, your tax is £15643"        |

  @basicRate
  Scenario: Basic rate tax payer
    Given an income of £10000
    When I calculate the taxes
    Then I find £2000

  @higherRate
  Scenario: Higher rate tax payer
    Given an income of £50000
    When I calculate the taxes
    Then I find £13643

  #Below scenario fails because on UI tax amount shown as £76142.6
  @additionalRate
  Scenario: Additional rate tax payer
    Given an income of £200000
    When I calculate the taxes
    Then I find £76143
