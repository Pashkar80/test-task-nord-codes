package com.aqa.services;

import static com.aqa.config.TestConfig.ERROR;
import static com.aqa.config.TestConfig.OK;
import static com.aqa.logger.Logger.info;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aqa.client.controller.ActionController;
import com.aqa.client.model.AppResponse;
import com.aqa.client.service.Service;
import io.qameta.allure.Step;

public class ActionOperations {

  public ActionController controller;

  public ActionOperations(Service service) {
    this.controller = new ActionController(service);
  }

  @Step
  public void actionUser(String token) {
    info("Action user");
    controller.sendActionRequest(token);
  }

  @Step
  public void sendActionRequestAndVerifyResultField(String token) {
    info("Verify field result in response from action request");
    AppResponse response = controller.sendActionRequestAndGetResponse(token);
    assertEquals(OK, response.result(), "Expected result doesn't match actual - " + response.result());
  }

  @Step
  public void sendActionRequestAndVerifyResponseData(String token, String message) {
    info("Verify field result and message in response from action request");
    AppResponse response = controller.sendActionRequestAndGetResponse(token);
    assertEquals(ERROR, response.result(),
        "Expected result doesn't match actual - " + response.result());
    assertEquals(message, response.message(),
        "Expected message doesn't match actual - " + response.message());
  }
}