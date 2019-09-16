@POSTRequests-Tests
Feature: Valdiating the POST functionality of the REST API


  @AddCustomer
  Scenario Outline: On receiving GET request the API should respond with requested customer data
    Given User is provided with an end point for customer search
    When User hits the end point with GET request with <CustomerID>
    Then the API should respond with all the customers data

    Examples: 
      | CustomerID |
      |          5 |
      |          1 |


  @AddItems
  Scenario Outline: On receiving GET request the API should respond with requested items data
    Given User is provided with an end point for item search
    When User hits the end point with GET request with <ItemNumber>
    Then the API should respond with all the items data

    Examples: 
      | ItemNumber |
      |          5 |
      |          6 |
