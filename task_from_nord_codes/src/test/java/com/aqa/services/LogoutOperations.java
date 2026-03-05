package com.aqa.services;

import static com.aqa.config.TestConfig.ERROR;
import static com.aqa.config.TestConfig.OK;
import static com.aqa.logger.Logger.info;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aqa.client.controller.LogoutController;
import com.aqa.client.model.AppResponse;
import com.aqa.client.service.Service;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

public class LogoutOperations {

  public LogoutController controller;

  public LogoutOperations(Service service) {
    this.controller = new LogoutController(service);
  }

  @Step
  public void logoutUser(String token){
    info("Logout user");
    controller.sendLogoutRequest(token);
  }

  @Step
  public void sendLogoutRequestAndVerifyResultField(String token) {
    info("Verify field result in response from logout request");
    AppResponse response = controller.sendLogoutRequestAndGetResponse(token);
    assertEquals(OK, response.result(), "Expected result doesn't match actual - " + response.result());
  }

  @Step
  public void sendLogoutRequestAndVerifyResponseData(String token, String message) {
    info("Verify field result and message in response from logout request");
    AppResponse response = controller.sendLogoutRequestAndGetResponse(token);
    assertEquals(ERROR, response.result(),
        "Expected result doesn't match actual - " + response.result());
    assertEquals(message, response.message(),
        "Expected message doesn't match actual - " + response.message());
  }
}