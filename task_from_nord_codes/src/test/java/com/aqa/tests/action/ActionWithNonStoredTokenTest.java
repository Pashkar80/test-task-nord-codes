package com.aqa.tests.action;

import com.aqa.services.ActionOperations;
import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

 class ActionWithNonStoredTokenTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String newToken = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + newToken + "' not found";
  private ActionOperations actionOperations;

  @BeforeEach
  void setUpStubsAndLogin() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    ActionStubs.stubActionSuccess(wireMockServer, token);
    LoginOperations loginOperations = new LoginOperations(service, requestSpec);
    actionOperations = new ActionOperations(service, requestSpec);
    loginOperations.loginUser(token);
  }

  @Test
  @DisplayName("Action with non stored token test")
  void actionWithNonStoredTokenTest() {
    actionOperations.sendActionRequestAndVerifyResponseData(newToken, expectedMessage);
  }
}