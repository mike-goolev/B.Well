@Header
# As a <type of user> I want <some goal> so that <some reason> ​

Feature:​ Content page header functionality

  Background:
    Given User is signed in

  @SignOut
  Scenario: User can sign out from the profile
    Given Content Demo Account button is displayed
    When I click on Demo Account button
    And I click on Sign out button
    Then I should be logged out and see sign in form

  @HeaderNavigation
  Scenario: ​User can click on all buttons in the header of the page
    Given Navigation tab buttons are displayed
    When I click on Analytics tab navigation
    Then I should be on "http://login.myappcms.com/analyze" analyze page
    When I click on Push Message tab navigation
    Then I should be on "http://login.myappcms.com/pushmessage" push messages page
    When I click on Manage Your App tab navigation
    Then I should be on "http://login.myappcms.com/build" page

  @Language
  Scenario: User can change language support for the application
    Given Content Demo Account button is displayed
    When I click on Demo Account button
    And I click on drop down menu
    And I select a language from drop down
    Then Tab navigation buttons should be translated
    And I select default English language
    Then Tab navigation buttons should be translated into English
