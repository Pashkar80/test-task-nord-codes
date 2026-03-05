package com.aqa.client.controller;

import static com.aqa.config.TestConfig.LOGOUT;

import com.aqa.client.builder.RequestBuilder;
import com.aqa.client.model.AppResponse;
import com.aqa.client.service.Service;

public class LogoutController {

  private Service service;

  public LogoutController(Service service) {
    this.service = service;
  }

  public void sendLogoutRequest(String token) {
    new RequestBuilder()
        .withToken(token)
        .withAction(LOGOUT)
        .build()
        .post(service.getLoginEndpoint());
  }

  public AppResponse sendLogoutRequestAndGetResponse(String token) {
    return new RequestBuilder()
        .withToken(token)
        .withAction(LOGOUT)
        .build()
        .post(service.getLoginEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }
}