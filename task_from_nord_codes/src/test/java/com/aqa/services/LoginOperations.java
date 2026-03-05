package com.aqa.services;

import static com.aqa.config.TestConfig.ERROR;
import static com.aqa.config.TestConfig.OK;
import static com.aqa.logger.Logger.info;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aqa.client.service.Service;
import com.aqa.client.controller.LoginController;
import com.aqa.client.model.AppResponse;
import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;

public class LoginOperations {

  public LoginController controller;

  public LoginOperations(Service service, RequestSpecification requestSpec) {
    this.controller = new LoginController(service, requestSpec);
  }

  @Step
  public void loginUser(String token) {
    info("Login user");
    controller.sendLoginRequest(token);
  }

  @Step
  public void sendLoginRequestAndVerifyResultField(String token) {
    info("Verify field result in response from login request");
    AppResponse response = controller.sendLoginRequestAndGetRequest(token);
    assertEquals(OK, response.result(), "Expected result doesn't match actual - " + response.result());
  }

  @Step
  public void sendLoginRequestAndVerifyResponseData(String token, String message) {
    info("Verify field result and message in response from login request");
    AppResponse response = controller.sendLoginRequestAndGetRequest(token);
    assertEquals(ERROR, response.result(),
        "Expected result doesn't match actual - " + response.result());
    assertEquals(message, response.message(),
        "Expected message doesn't match actual - " + response.message());
  }

  @Step
  public void sendInvalidLoginRequestAndVerifyData(String token, String message) {
    info("Send login request with custom spec and verify response data");
    AppResponse response = controller.sendLoginRequestWithCustomSpec(token);
    assertEquals(ERROR, response.result(),
        "Expected result doesn't match actual - " + response.result());
    assertEquals(message, response.message(),
        "Expected message doesn't match actual - " + response.message());
  }
}