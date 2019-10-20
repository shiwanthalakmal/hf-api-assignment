package com.hellofresh.api.step_definitions;

import com.github.javafaker.Faker;
import com.hellofresh.api.step_definitions.pojo.Booking;
import com.hellofresh.api.step_definitions.pojo.BookingDates;
import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class BookingDetailStepDefs {

    Response response;
    Faker faker = new Faker();
    ValidatableResponse validatableResponse;

    @Given("^The webservice is up and running$")
    public void theWebserviceIsUpAndRunning() {
        given().get("/").then().statusCode(200);
    }

    @Then("^The response code should be \"([^\"]*)\"$")
    public void TheStatusCodeShouldBe(String statusCode) throws Throwable {
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }

    @And("^The response should be returned in a valid JSON format$")
    public void TheResponseShouldBeReturnedInAValidJSONFormat() {
        URL schema_path = this.getClass().getClassLoader().getResource("response/booking-responce");
        validatableResponse.body(matchesJsonSchema(new File(schema_path.getPath())));
    }

    @Given("^The booking service is up and running$")
    public void theBookingServiceIsUpAndRunning() {
        given().get("/").then().statusCode(200);
    }

    @When("^Customer want to get information of all bookings$")
    public void customerWantToGetInformationOfAllBookings() {
        validatableResponse = given().get("/").then();
        response = validatableResponse.extract().response();
    }

    @And("^The returned response should include the following booking id's$")
    public void TheReturnedResponseShouldIncludeTheFollowingBookingIdS(DataTable table) {
        List<Integer> countries = new ArrayList<Integer>();
        countries = table.asList(Integer.class);
        for (Integer country : countries) {
            validatableResponse.assertThat().body("bookings.bookingid", hasItem(country));
        }
    }

    @And("^The returned response should include \"([^\"]*)\", \"([^\"]*)\", and \"([^\"]*)\"$")
    public void TheReturnedResponseShouldIncludeAnd(String fname, String lname, String booking_id) {
        validatableResponse.assertThat()
                .root("bookings")
                .body("firstname", hasItem(fname))
                .body("lastname", hasItem(lname))
                .body("bookingid", hasItem(Integer.parseInt(booking_id)));
    }

    @When("^Customer wants to add a new booking records$")
    public void customerWantsToAddANewBookingRecords() {
        RequestSpecification httpRequest = given();
        httpRequest.header("Content-Type", "application/json");
        BookingDates bookingDates = new BookingDates("2019-10-"+String.valueOf(faker.number().numberBetween(1, 30)) , "2020-11-"+String.valueOf(faker.number().numberBetween(1, 30)));
        Booking booking = new Booking(bookingDates);
        httpRequest.body(booking);
        validatableResponse = httpRequest.post("/createBooking").then();
        response = validatableResponse.extract().response();
    }
}
