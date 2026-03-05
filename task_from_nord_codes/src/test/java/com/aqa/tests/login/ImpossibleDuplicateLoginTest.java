package com.aqa.tests.login;

import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImpossibleDuplicateLoginTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' already exists";
  private LoginOperations loginOperations;

  @BeforeEach
  void setUpStubAndLogin() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    loginOperations = new LoginOperations(service, requestSpec);
    loginOperations.loginUser(token);
  }

  @Test
  @DisplayName("Impossible duplicate login with same token test")
  void duplicateLoginTest() {
    loginOperations.sendLoginRequestAndVerifyResponseData(token, expectedMessage);
  }
}