Feature: Business Requirements

  #get method
  Scenario: Get Single user and validate response code is 200 and email exist
    Given header "accept" is "application/json"
    When get path "/users/1"
    Then status code should be 200
    And integer value of "data.id" field is 1
    And string value of "data.first_name" field is "George"

    #list size
  Scenario: Get all users and validate list size
    Given header "accept" is "application/json"
    When get path "/users?page=2"
    Then status code should be 200
    And user should see "data" list size should be 6

    #value control
  Scenario: Get all users and first user name
    Given header "accept" is "application/json"
    When get path "/users?page=2"
    Then status code should be 200
    And string value of "data[0].first_name" field is "Michael"

    #contains text
  Scenario: Get all user and support info
    Given header "accept" is "application/json"
    When get path "/users?page=2"
    Then status code should be 200
    And string value of "support.url" field contains "support"

      #post request
  Scenario: create new user and validate status code given user information
    Given header "accept" is "application/json"
    And request body is "/create-user.json"
    When post path "/users"
    Then status code should be 201
    And string value of "name" field is "bus"

        #schema control
  Scenario: Schema control
    Given header "accept" is "application/json"
    When get path "/users/1"
    Then status code should be 200
    And response schema should be "/single-user-response-schema.json"
