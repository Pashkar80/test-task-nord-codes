package com.aqa.tests.logout;

import com.aqa.services.LogoutOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImpossibleLogoutWithoutLoginTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' not found";
  private LogoutOperations logoutOperations;

  @BeforeEach
  void setUpStub() {
    ActionStubs.stubActionSuccess(wireMockServer, token);
    logoutOperations = new LogoutOperations(service, requestSpec);
  }

  @Test
  @DisplayName("Impossible logout without login test")
  void impossibleLogoutWithoutLoginTest() {
    logoutOperations.sendLogoutRequestAndVerifyResponseData(token, expectedMessage);
  }
}