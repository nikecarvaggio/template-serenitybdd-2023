
# Author: Nicolas

@stories

Feature: Search available pet
  Scenario: Searching for kitty

    Given Kitty is available in the pet store
    When I ask for a pet using Kitty's ID: 9222968140497181183
    Then I get Kitty as result