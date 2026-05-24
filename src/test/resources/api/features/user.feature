@api
Feature: CRM User API

  Scenario: Get list user
    Given User set GET endpoint
    When User send GET request
    Then Response status should be 200

  Scenario: Get user with invalid ID
    Given User set GET endpoint
    When User send invalid GET request
    Then Response status should be 404