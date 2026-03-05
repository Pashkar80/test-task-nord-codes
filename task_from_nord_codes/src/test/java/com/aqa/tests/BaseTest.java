package com.aqa.tests;

import static com.aqa.config.TestConfig.MOCK_PORT;

import com.aqa.client.service.Service;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

  protected WireMockServer wireMockServer;
  protected RequestSpecification requestSpec;
  protected Service service;

  @BeforeEach
  void setUpBase() {
    RestAssured.filters(
        new RequestLoggingFilter(),
        new ResponseLoggingFilter(),
        new AllureRestAssured()
    );
    wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig()
        .port(MOCK_PORT)
        .bindAddress("localhost"));
    wireMockServer.start();
    service = new Service();
  }

  @AfterEach
  void tearDownBase() {
    if (wireMockServer != null) {
      wireMockServer.stop();
    }
  }
}