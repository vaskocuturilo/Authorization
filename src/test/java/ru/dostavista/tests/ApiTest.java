package ru.dostavista.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTest {

    @Test
    public void testMainApi() {
        RestAssured.baseURI = "https://dostavista.ru";
        RequestSpecification requestSpecification = RestAssured.given()
                .contentType("application/json; charset=UTF-8")
                .accept("application/json, application/javascript, text/javascript, text/json")
                .log().all();
        requestSpecification
                .params("phone","9999999999")
                .params("password","qwerty123456")
                .formParam("phone", "99999999999")
                .formParam("password", "qwerty123456");
        Response response = requestSpecification.post("/user-login");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);


    }
}
