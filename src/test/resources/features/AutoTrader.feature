Feature:

  @unit_test
  Scenario: Testing AutoTrader.com
    Given user is on the landing page
    Then verify that "Browser By Make" are present
    Then verify that "Browser By Style" are present
    Then verify that "Advanced Search" are present
    And verify that search button is present
    Then verify that "Any Make" and "Any Model" is present



  Scenario: Entering the Advance Search link
    Given user click Advance Search on the home page
    Then user enter "30004" in the zipcode text box
    Then user select "Certified" check box under "Condition"
    Then user select "Convertable" check box under "Style"
    Then user update year "2017" to "2020"
    Then selects "BMW" from Make, Model, and Trim
    Then user click Search Button
    Then user verify that it is the result page
    Then user verify that there is only "BMW" cars in the listing
    Then display the number of the cars on the console


    Scenario Outline: testing the multiple entry
      Given choose make as "<model>"
      Examples:
      |model   |
      |BMW     |
      |Audi    |
      |Mercedes|
      |Toyota  |
      |Acura   |

