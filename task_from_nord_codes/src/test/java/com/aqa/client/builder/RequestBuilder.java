package com.aqa.client.builder;


import static com.aqa.config.TestConfig.API_KEY;
import static com.aqa.config.TestConfig.ENDPOINT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

  private String token;
  private String action;
  private RequestSpecification requestSpec;

  public RequestBuilder() {
    this.requestSpec = RestAssured.given()
        .contentType(ContentType.URLENC)
        .header("X-Api-Key", API_KEY)
        .basePath(ENDPOINT);
  }

  public RequestBuilder(RequestSpecification requestSpec) {
    this.requestSpec = requestSpec;
  }

  public RequestBuilder withToken(String token) {
    this.token = token;
    return this;
  }

  public RequestBuilder withAction(String action) {
    this.action = action;
    return this;
  }

  public RequestSpecification build() {
    return RestAssured.given()
        .spec(requestSpec)
        .formParam("token", token)
        .formParam("action", action);
  }
}