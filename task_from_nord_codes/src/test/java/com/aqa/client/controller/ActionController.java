package com.aqa.client.controller;

import static com.aqa.config.TestConfig.ACTION;

import com.aqa.client.builder.RequestBuilder;
import com.aqa.client.model.AppResponse;
import com.aqa.client.service.Service;

public class ActionController {

  private Service service;

  public ActionController(Service service) {
    this.service = service;
  }

  public void sendActionRequest(String token) {
    new RequestBuilder()
        .withToken(token)
        .withAction(ACTION)
        .build()
        .post(service.getEndpoint());
  }

  public AppResponse sendActionRequestAndGetResponse(String token) {
    return new RequestBuilder()
        .withToken(token)
        .withAction(ACTION)
        .build()
        .post(service.getEndpoint())
        .then()
        .extract()
        .as(AppResponse.class);
  }
}