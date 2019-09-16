@GETRequests-Tests
Feature: Valdiating the GET functionality of the REST API

  @GetCustomers
  Scenario: On receiving GET request the API should respond with requested customers data
    Given User is provided with an end point for customers search
    When User hits the end point with GET request
    Then the API should respond with all the customers data

  @GetCustomersWithCustomerId
  Scenario Outline: On receiving GET request the API should respond with requested customer data only
    Given User is provided with an end point for customer search
    When User hits the end point with GET request with <CustomerID>
    Then the API should respond with all the customers data

    Examples: 
      | CustomerID |
      |          5 |
      |          1 |

  @GetItems
  Scenario: On receiving GET request the API should respond with requested items data
    Given User is provided with an end point for items search
    When User hits the end point with GET request
    Then the API should respond with all the items data

  @GetItemsWithItemNumber
  Scenario Outline: On receiving GET request the API should respond with requested item data only
    Given User is provided with an end point for item search
    When User hits the end point with GET request with <ItemNumber>
    Then the API should respond with all the items data

    Examples: 
      | ItemNumber |
      |          5 |
      |          6 |
