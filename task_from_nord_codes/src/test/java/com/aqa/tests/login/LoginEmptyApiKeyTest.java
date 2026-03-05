package com.aqa.tests.login;

import static com.aqa.config.TestConfig.API_KEY_ERROR_MESSAGE;
import static com.aqa.config.TestConfig.ENDPOINT;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.URLENC;

import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginEmptyApiKeyTest extends BaseTest {

  private String token = TokenGenerator.generateValidToken();
  private String emptyApiKey = "";
  private RequestSpecification customSpec;
  private LoginOperations loginOperations;

  @BeforeEach
  void getCustomSpec() {
    customSpec = RestAssured.given()
        .contentType(URLENC)
        .accept(JSON)
        .header("X-Api-Key", emptyApiKey)
        .basePath(ENDPOINT);
    loginOperations = new LoginOperations(service, customSpec);
  }

  @Test
  @DisplayName("Request with empty API key test")
  void withEmptyApiKeyTest() {
    loginOperations.sendInvalidLoginRequestAndVerifyData(token, API_KEY_ERROR_MESSAGE);
  }
}