package com.aqa.tests.login;

import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.AuthStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SuccessfulLoginTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private LoginOperations loginOperations;

  @BeforeEach
  void setUp() {
    AuthStubs.stubAuthSuccess(wireMockServer, token);
    loginOperations = new LoginOperations(service, requestSpec);
  }

  @Test
  @DisplayName("Successful login test")
  void successfulLoginTest() {
    loginOperations.sendLoginRequestAndVerifyResultField(token);
  }
}