package com.aqa.tests.logout;

import com.aqa.services.LoginOperations;
import com.aqa.services.LogoutOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImpossibleDuplicateLogoutTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' not found";
  private LogoutOperations logoutOperations;

  @BeforeEach
  void setUpStubsAndLogin() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    ActionStubs.stubActionSuccess(wireMockServer, token);
    LoginOperations loginOperations = new LoginOperations(service, requestSpec);
    logoutOperations = new LogoutOperations(service, requestSpec);
    loginOperations.loginUser(token);
  }

  @Test
  @DisplayName("Impossible duplicate logout test")
  void impossibleDuplicateLogoutTest() {
    logoutOperations.logoutUser(token);
    logoutOperations.sendLogoutRequestAndVerifyResponseData(token, expectedMessage);
  }
}