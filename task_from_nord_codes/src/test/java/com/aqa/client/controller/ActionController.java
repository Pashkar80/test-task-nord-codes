package com.aqa.client.controller;

import static com.aqa.config.TestConfig.ACTION;

import com.aqa.client.service.Service;
import com.aqa.client.builder.RequestBuilder;
import com.aqa.client.model.AppResponse;
import io.restassured.specification.RequestSpecification;

public class ActionController {

  private Service service;
  private RequestSpecification requestSpec;

  public ActionController(Service service, RequestSpecification requestSpec) {
    this.service = service;
    this.requestSpec = requestSpec;
  }

  public void sendActionRequest(String token) {
    new RequestBuilder()
        .withToken(token)
        .withAction(ACTION)
        .build()
        .post(service.getLoginEndpoint());
  }

  public AppResponse sendActionRequestAndGetResponse(String token) {
    return new RequestBuilder()
        .withToken(token)
        .withAction(ACTION)
        .build()
        .post(service.getLoginEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }
}