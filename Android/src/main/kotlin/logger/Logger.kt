package logger

import org.apache.logging.log4j.LogManager

internal object Logger {
  private val logger = LogManager.getLogger()

  fun info(message: String) {
    logger.info(message)
  }
}