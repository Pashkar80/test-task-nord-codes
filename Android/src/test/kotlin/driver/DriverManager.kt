package driver

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.MutableCapabilities
import tests.driver.EmulatorDriver

object DriverManager {

  fun initDriver(): AndroidDriver {
    Configuration.browser = EmulatorDriver::class.java.name
    Configuration.browserCapabilities = MutableCapabilities()
    Configuration.browserSize = null
    Configuration.pageLoadTimeout = 0
    Selenide.open()
    return getDriver()
  }

  private fun getDriver(): AndroidDriver {
    return try {
      WebDriverRunner.getWebDriver() as AndroidDriver
    } catch (e: Exception) {
      throw IllegalStateException("Драйвер не инициализирован", e)
    }
  }

  fun quitDriver() {
    if (WebDriverRunner.hasWebDriverStarted()) {
      Selenide.closeWebDriver()
    }
  }
}