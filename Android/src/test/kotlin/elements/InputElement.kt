package elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.SelenideAppium.`$`
import org.openqa.selenium.By

internal object InputElement {

  fun setInputFieldWithSendKeys(value: String?, element: SelenideElement) {
    value?.let { inputValue ->
      element.apply {
        shouldBe(Condition.visible).click() // to investigate
        clear()
        sendKeys(inputValue)
      }
    }
  }

  fun setInputFieldWithSendKeys(value: String?, locator: By) {
    setInputFieldWithSendKeys(value, `$`(locator))
  }
}