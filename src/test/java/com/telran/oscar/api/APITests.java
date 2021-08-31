package com.telran.oscar.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITests {

    //jfwNG7lYUx93B0w8T5NDPPyLzSZFRi4fbaqPMomWE9OBOeQreVBbIiE5jBpoZdzk
    //https://selenium1py.pythonanywhere.com/en-gb/accounts/login/

    @Test
    public void loginPositiveTest(){
        RequestSpecification requestSpecification = io.restassured.RestAssured.given();
        Response response = requestSpecification.contentType(ContentType.HTML)
               .given().header("Authorization","jfwNG7lYUx93B0w8T5NDPPyLzSZFRi4fbaqPMomWE9OBOeQreVBbIiE5jBpoZdzk")
                .given().body("{\n" +
                        "    \"username\": \"zebra@gmail.com\",\n" +
                        "    \"password\": \"Zebra_1812\n\"\n" +
                        "}")
                .when().post("https://selenium1py.pythonanywhere.com/en-gb/accounts/login/");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
    }
}
