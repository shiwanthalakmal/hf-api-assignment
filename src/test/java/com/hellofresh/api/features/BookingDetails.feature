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
      | RtbRGxjp  | WJXPjeNN | 8         |
      | DvrmWmHB  | JtfrpVUk | 9         |

  @Smoke
  Scenario: Add a new booking through POST request and validate the response
    When Customer wants to add a new booking records
    Then The response code should be "201"