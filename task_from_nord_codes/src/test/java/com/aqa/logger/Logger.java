package com.aqa.logger;

public class Logger {

  private static final org.apache.logging.log4j.Logger logger =
      org.apache.logging.log4j.LogManager.getLogger(Logger.class);

  public static void info(String message) {
    logger.info(message);
  }
}