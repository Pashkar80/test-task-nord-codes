package driver

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.MutableCapabilities

internal object DriverManager {
  private var driverInstance: AndroidDriver? = null

  fun initDriver(): AndroidDriver {
    if (driverInstance != null) return driverInstance!!
    Configuration.browser = EmulatorDriver::class.java.name
    Configuration.browserCapabilities = MutableCapabilities()
    Configuration.browserSize = null
    Configuration.pageLoadTimeout = 0
    Selenide.open()
    driverInstance = getWebDriver() as AndroidDriver
    return driverInstance!!
  }

  fun quitDriver() {
    if (hasWebDriverStarted()) {
      driverInstance?.quit()
      driverInstance = null
      Selenide.closeWebDriver()
    }
  }

  fun getCurrentDriver(): AndroidDriver {
    return driverInstance ?: error("Driver not initialized")
  }
}