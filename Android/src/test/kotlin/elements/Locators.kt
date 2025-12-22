package elements

import io.appium.java_client.AppiumBy.androidUIAutomator
import org.openqa.selenium.By

internal object Locators {

  fun byText(text: String): By {
    return androidUIAutomator("new UiSelector().text(\"$text\")")
  }
}