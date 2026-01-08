package tests

import logger.Logger.info
import org.junit.jupiter.api.Test
import java.io.File

  class LogTest {

    @Test
    fun testLogging() {
      // Проверяем что файл существует
      val configPath = "src/test/resources/log4j2.properties"
      val configFile = File(configPath)
      println("Config exists: ${configFile.exists()}")
      println("Config path: ${configFile.absolutePath}")

      // Тестируем логгер
      info("Тестовое INFO сообщение")
      println("=== Проверь консоль выше ===")
    }
  }