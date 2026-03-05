package com.aqa.tests.login;

import static com.aqa.config.TestConfig.TOKEN_ERROR_MESSAGE;
import static com.aqa.logger.Logger.info;

import com.aqa.services.LoginOperations;
import com.aqa.tests.BaseTest;
import com.aqa.utils.TokenGenerator;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginWithInvalidTokenTest extends BaseTest {

  public static final char[] invalidSpecialCharacters =
      "@!#$%^&*()-+={}[]|\\;:'\",<>,.?/".toCharArray();
  public static final char[] invalidLetters = "GHIJKLMNOPQRSTUVWXYZ".toCharArray();
  public static final char[] lowRegisterLetters = "abcdef".toCharArray();

  @ParameterizedTest(name = "[{index}] {1}")
  @DisplayName("Login with invalid token test")
  @MethodSource("provideInvalidTokens")
  void invalidTokenTest(String token, String reason) {
    info("Testing: " + token + " (reason: " + reason + ")");
    LoginOperations loginOperations = new LoginOperations(service, requestSpec);
    loginOperations.sendLoginRequestAndVerifyResponseData(token, TOKEN_ERROR_MESSAGE);
  }

  private static Stream<Arguments> provideInvalidTokens() {
    return Stream.of(
        Arguments.of(TokenGenerator.generateToken(10), "Too short token(10 characters)"),
        Arguments.of(TokenGenerator.generateToken(33), "The boundary value of the length (33 characters)"),
        Arguments.of(TokenGenerator.generateToken(31), "The boundary value of the length (31 characters)"),
        Arguments.of(TokenGenerator.generateTokenWithInvalidChars(invalidSpecialCharacters),
            "Token with invalid characters"),
        Arguments.of(TokenGenerator.generateTokenWithInvalidChars(invalidLetters), "Token with invalid letters"),
        Arguments.of(TokenGenerator.generateTokenWithInvalidChars(lowRegisterLetters),
            "Token valid lowercase letters"),
        Arguments.of(" " + TokenGenerator.generateToken(31), "Token with space at the beginning"),
        Arguments.of(TokenGenerator.generateToken(31) + " ", "Token with space at the end"),
        Arguments.of("", "Empty token"),
        Arguments.of(" ", "Space as token")
    );
  }
}