@api
Feature: CRM User API

  Scenario: Get user by ID
    Given User set GET endpoint
    When User send GET request
    Then Response status should be 200

  Scenario: Get user with invalid ID
    Given User set invalid GET endpoint
    When User send GET request
    Then Response status should be 404