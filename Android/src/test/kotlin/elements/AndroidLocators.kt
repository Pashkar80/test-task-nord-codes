package elements

import domains.AndroidTagType.TEXT_VIEW_TAG
import io.appium.java_client.AppiumBy.androidUIAutomator
import org.openqa.selenium.By

internal object AndroidLocators {

  fun byText(text: String): By {
    return androidUIAutomator("new UiSelector().text(\"$text\")")
  }

  fun textViewByText(text: String): By {
    return androidUIAutomator(
      "new UiSelector().className(${TEXT_VIEW_TAG.layoutValue}).text(\"$text\")"
    )
  }
}