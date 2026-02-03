package elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.SelenideAppium.`$`
import org.openqa.selenium.By

internal object InputElement {

  fun setInputFieldWithSendKeys(
    value: String?,
    element: SelenideElement,
    shouldScrollTo: Boolean = false
  ) {
    value?.let { inputValue ->
      element.apply {
        if (shouldScrollTo) scrollTo()
        shouldBe(Condition.visible).click()
        sendKeys(inputValue)
      }
    }
  }

  fun setInputFieldWithSendKeys(value: String?, locator: By) {
    setInputFieldWithSendKeys(value, `$`(locator))
  }
}