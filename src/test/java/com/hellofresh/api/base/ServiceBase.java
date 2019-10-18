package com.hellofresh.api.base;

import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class ServiceBase {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://automationintesting.online";
        RestAssured.basePath = "/booking/";
    }
}
