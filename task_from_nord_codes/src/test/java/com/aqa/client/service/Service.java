package com.aqa.client.service;

import static com.aqa.config.TestConfig.BASE_URL;
import static com.aqa.config.TestConfig.ENDPOINT;

public class Service {

  public String getEndpoint() {
    return BASE_URL + ENDPOINT;
  }
}