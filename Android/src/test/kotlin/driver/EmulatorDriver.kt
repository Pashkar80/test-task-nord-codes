package driver

import com.codeborne.selenide.WebDriverProvider
import config.EmulatorConfigData
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import provider.EmulatorConfigDataProvider
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration.ofSeconds

internal class EmulatorDriver : WebDriverProvider {
  private val config: EmulatorConfigData = EmulatorConfigDataProvider().readEmulatorConfigData()
  private val newCommandTimeout : Long = 300
  private val adbExecTimeout : Long = 60000

  override fun createDriver(capabilities: Capabilities): WebDriver {
    val options = createUiAutomator2Options()
    return AndroidDriver(getUrl(), options)
  }

  private fun getUrl(): URL {
    try {
      return URL(config.remoteURL)
    } catch (e: MalformedURLException) {
      throw RuntimeException("Некорректный URL: ${config.remoteURL}", e)
    }
  }

  private fun getAbsolutePath(filePath: String): String {
    val file = File(filePath)
    require(file.exists()) { "Файл не найден: $filePath" }
    return file.absolutePath
  }

  private fun createUiAutomator2Options(): UiAutomator2Options {
    with(config) {
      return UiAutomator2Options()
        .setPlatformName(platformName)
        .setDeviceName(deviceName)
        .setAutomationName(automationName)
        .setApp(getAbsolutePath(config.app!!))
        .setAutoGrantPermissions(true)
        .setDisableWindowAnimation(true)
        .setIsHeadless(false)
        .setNewCommandTimeout(ofSeconds(newCommandTimeout))
        .setAdbExecTimeout(ofSeconds(adbExecTimeout))
        .setPrintPageSourceOnFindFailure(true)
        .setEnforceAppInstall(true)
        .setEnsureWebviewsHavePages(true)
        .setNativeWebScreenshot(true)
        .setNoReset(false)
    }
  }
}