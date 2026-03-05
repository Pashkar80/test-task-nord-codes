package com.aqa.tests.login;

import com.aqa.services.ActionOperations;
import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginActionLoginFlowTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' already exists";
  private LoginOperations loginOperations;

  @BeforeEach
  void setUpStubsLoginAndAction() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    ActionStubs.stubActionSuccess(wireMockServer, token);
    loginOperations = new LoginOperations(service, requestSpec);
    ActionOperations actionOperations = new ActionOperations(service, requestSpec);
    loginOperations.loginUser(token);
    actionOperations.actionUser(token);
  }

  @Test
  @DisplayName("Login action login flow test")
  void loginActionLoginFlowTest() {
    loginOperations.sendLoginRequestAndVerifyResponseData(token, expectedMessage);
  }
}