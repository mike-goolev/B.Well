@desktop @web @QA_task
# As a <type of user> I want <some goal> so that <some reason> ​

Feature:​ BWell Automation QATask
  As a QA who is interested in BBWellAutomationWell
  I want to solve interview task
  So that I can be confident if get invited on a meeting

  Background: Sign In
    Given I am on "http://login.myappcms.com/" home page
    When I type ​string as App Name
    And I type ​username​ as Email address
    And I type ​password as Password
    And I click on Sign in button

  @SignIn
  Scenario: ​User can Sign in with valid credentials
    Then I should see my Content

  @Sorting
  Scenario: ​User can sort in ascending order all Appointments services by name ​
    Given I am on "http://login.myappcms.com/build" page
    When I click ​Sort Ascending option​ on ​Service Name​ column
    Then I should see correct results list after sorting

  @Searching
  Scenario: ​ User can search all Appointments services by name
    Given I am on "http://login.myappcms.com/build" page
    When I type ​keyword​ in the Search box
    Then I should see correct results list after searching
