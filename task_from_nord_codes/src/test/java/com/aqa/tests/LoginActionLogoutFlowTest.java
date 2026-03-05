package com.aqa.tests;

import com.aqa.services.ActionOperations;
import com.aqa.services.LoginOperations;
import com.aqa.services.LogoutOperations;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginActionLogoutFlowTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private LogoutOperations logoutOperations;

  @BeforeEach
  void setUpStubsAndLogin() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    ActionStubs.stubActionSuccess(wireMockServer, token);
    LoginOperations loginOperations = new LoginOperations(service, requestSpec);
    ActionOperations actionOperations = new ActionOperations(service, requestSpec);
    logoutOperations = new LogoutOperations(service, requestSpec);
    loginOperations.loginUser(token);
    actionOperations.actionUser(token);
  }

  @Test
  @DisplayName("Login action logout flow test")
  void loginActionLogoutFlowTest() {
    logoutOperations.sendLogoutRequestAndVerifyResultField(token);
  }
}