@qa
Feature: Create a Policy
  
  
  Background: Successful Policy Creation
    Given the user selects "Insurance Project" on the Home Page
    Then the user navigates to the "Insurance Broker System - Login" Login Page
    When the user enters "Tester1@123.com" and "Tester@123"
    Then a message is displayed "Signed in as"
    
  @clearform
  Scenario: Request Quotation
    Given user on the registration quotation page
    When user selects "<Breakdowncover>"
    And user clicks the radio button "<Windscreenrepair>"
    And user enters "<incident>","<Registration>","<mileage>","<veichlevalue>"
    And user selects qutoation details "<location>","<year>","<month>","<date>"
    And user selects calculate prememium
    Then the premimum should calculated sucessfully 
    
     Examples:
     |Breakdowncover|Windscreenrepair|incident|Registration|mileage|veichlevalue|location    |year|month|date|
     | European     | Yes            |Accident|Registered  | 50    | 500000   |Public Place|2022|  May|20  |  
   #  | Roadside     | No             |Theft   |Registered  | 80    | 800000   |Public Place|2021|  May|25  | 
   
  @uat
    Examples:
     |Breakdowncover|Windscreenrepair|incident|Registration|mileage|veichlevalue|location    |year|month|date|
     | Roadside     | No             |Theft   |Registered  | 80    | 800000   |Public Place|2021|  May|25  | 
   
  
  Scenario Outline: clear enter text after clicking reset form
   Given user on the registration quotation page
    When user selects "<Breakdowncover>"
    And user clicks the radio button "<Windscreenrepair>"
    And user enters "<incident>","<Registration>","<mileage>","<veichlevalue>"
    And user selects qutoation details "<location>","<year>","<month>","<date>"
    And user selects Reset form
    Then text should be cleared
    
    Examples:
     |Breakdowncover|Windscreenrepair|incident|Registration|mileage|veichlevalue|location    |year|month|date|
     | European     | Yes            |Accident|Registered  | 50    | 500000   |Public Place|2022|  May|20  | 
     
    
    Scenario: Retrive Quotation
    Given user on the retrieve quotation page 
    When user enters identification
    And click on retrive buton
    Then Quotation details should get retrieved sucessfully 
    
    
    