Feature: Booking details filter and creation Feature
  As a user I should be able retrieve the booking details from a web service and verify them

  Background: Booking.com services up and running
    Given The booking service is up and running

  @Smoke
  Scenario: Get all booking and validate at least two booking available
    When Customer want to get information of all bookings
    Then The response code should be "200"
    And The response should be returned in a valid JSON format
    And The returned response should include the following booking id's
      | 159 |
      | 160 |

  @Smoke
  Scenario Outline: Get each bookings and validate the given booking records availability
    When Customer want to get information of all bookings
    Then The response code should be "200"
    And The response should be returned in a valid JSON format
    And The returned response should include "<firstname>", "<lastname>", and "<bookingid>"
    Examples:
      | firstname | lastname | bookingid |
      | YyoBOvpY  | oRVyBugJ | 14        |
      | bFcIzlHB  | fnxFRlgK | 10        |
      | qPhUEQly  | HHOOZQUp | 11        |

