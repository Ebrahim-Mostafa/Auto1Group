Feature: Test the Search page on Autohero test environment

  Scenario Outline: Search Page
  the user should be able to filter by first registration from 2015
    Given user is on the dashboard page
    When user click on find your car button
    Then user will be navigated to search page
    And user will sort by first registration
    Then all cars are filtered by first registration
    And user will sort by price descending
    Then all cars are filtered by price descending
    Examples:
      |  |