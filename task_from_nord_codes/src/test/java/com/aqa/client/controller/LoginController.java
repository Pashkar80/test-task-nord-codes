package com.aqa.client.controller;

import static com.aqa.config.TestConfig.LOGIN;

import com.aqa.client.builder.RequestBuilder;
import com.aqa.client.model.AppResponse;
import com.aqa.client.service.Service;
import io.restassured.specification.RequestSpecification;

public class LoginController {

  private Service service;
  private RequestSpecification requestSpec;

  public LoginController(Service service, RequestSpecification requestSpec) {
    this.service = service;
    this.requestSpec = requestSpec;
  }
  public void sendLoginRequest(String token) {
    new RequestBuilder()
        .withToken(token)
        .withAction(LOGIN)
        .build()
        .post(service.getEndpoint());
  }

  public AppResponse sendLoginRequestAndGetRequest(String token) {
    return new RequestBuilder()
        .withToken(token)
        .withAction(LOGIN)
        .build()
        .post(service.getEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }

  public AppResponse sendLoginRequestWithCustomSpec(String token){
    return new RequestBuilder(requestSpec)
        .withToken(token)
        .withAction(LOGIN)
        .build()
        .post(service.getEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }
}