package com.aqa.utils;

import java.security.SecureRandom;

public class TokenGenerator {

  private static final SecureRandom random = new SecureRandom();
  private static final char[] ALPHANUMERIC = "0123456789ABCDEF".toCharArray();
  private static final int TOKEN_LENGTH = 32;


  public static String generateToken(int length) {
    char[] tokenChars = new char[length];

    for (int i = 0; i < length; i++) {
      tokenChars[i] = ALPHANUMERIC[random.nextInt(ALPHANUMERIC.length)];
    }
    return new String(tokenChars);
  }

  public static String generateValidToken() {
    return generateToken(TOKEN_LENGTH);
  }

  public static String generateTokenWithInvalidChars(char[] charsArray) {
    String token = generateValidToken();
    SecureRandom random = new SecureRandom();
    int position = random.nextInt(token.length() + 1);
    char randomChar = charsArray[random.nextInt(charsArray.length)];
    return token.substring(0, position) + randomChar + token.substring(position);
  }
}