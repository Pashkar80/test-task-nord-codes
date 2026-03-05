package com.aqa.utils.stubs;

import static com.aqa.config.StubsConfig.ACCEPT_HEADER;
import static com.aqa.config.StubsConfig.ACCEPT_VALUE;
import static com.aqa.config.StubsConfig.AUTH_URL;
import static com.aqa.config.StubsConfig.CONTENT_TYPE_HEADER;
import static com.aqa.config.StubsConfig.CONTENT_TYPE_VALUE;
import static com.aqa.config.StubsConfig.RESPONSE_CONTENT_TYPE;
import static com.aqa.config.StubsConfig.STATUS_OK;
import static com.aqa.config.StubsConfig.TOKEN_PARAM;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;

public class AuthStubs {

  private AuthStubs() {
  }

  public static void stubAuthSuccess(WireMockServer server, String token) {
    server.stubFor(createBaseAuthStub(token)
        .willReturn(createBaseResponse(STATUS_OK)
            .withBody("{\"result\": \"OK\"}")));
  }

  private static MappingBuilder createBaseAuthStub(String token) {
    return post(urlEqualTo(AUTH_URL))
        .withHeader(CONTENT_TYPE_HEADER, containing(CONTENT_TYPE_VALUE))
        .withHeader(ACCEPT_HEADER, containing(ACCEPT_VALUE))
        .withRequestBody(containing(TOKEN_PARAM + token));
  }

  private static ResponseDefinitionBuilder createBaseResponse(int statusCode) {
    return aResponse()
        .withStatus(statusCode)
        .withHeader(CONTENT_TYPE_HEADER, RESPONSE_CONTENT_TYPE);
  }
}