package com.aqa.tests.action;

import com.aqa.services.ActionOperations;
import com.aqa.services.LoginOperations;
import com.aqa.services.LogoutOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImpossibleActionAfterLogoutTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' not found";
  private ActionOperations actionOperations;

  @BeforeEach
  void setUpStubsLoginAndLogout() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    ActionStubs.stubActionSuccess(wireMockServer, token);
    actionOperations = new ActionOperations(service, requestSpec);
    LogoutOperations logoutOperations = new LogoutOperations(service, requestSpec);
    LoginOperations loginOperations = new LoginOperations(service, requestSpec);
    loginOperations.loginUser(token);
    logoutOperations.logoutUser(token);
  }

  @Test
  @DisplayName("Impossible action after logout test")
  void impossibleActionAfterLogoutTest() {
    actionOperations.sendActionRequestAndVerifyResponseData(token, expectedMessage);
  }
}