package com.aqa.tests.action;

import com.aqa.services.ActionOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import com.aqa.utils.stubs.ActionStubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UnauthorizedActionTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String expectedMessage = "Token '" + token + "' not found";
  private ActionOperations actionOperations;

  @BeforeEach
  void setUpStub() {
    ActionStubs.stubActionSuccess(wireMockServer, token);
    actionOperations = new ActionOperations(service, requestSpec);
  }

  @Test
  @DisplayName("Unauthorized action test")
  void unauthorizedActionTest() {
    actionOperations.sendActionRequestAndVerifyResponseData(token, expectedMessage);
  }
}