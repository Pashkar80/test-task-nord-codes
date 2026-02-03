package widgets

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.appium.SelenideAppium.`$`
import domains.AndroidTagType.TEXT_VIEW_TAG
import org.openqa.selenium.By

internal abstract class BaseBlock {
  protected abstract val baseBlockLocator: By
  protected val fieldValueLocatorPattern: String = ".//${TEXT_VIEW_TAG.layoutValue}[@text='%s']"

  fun verifyFieldWithTextIsVisible(value: String) {
    `$`(baseBlockLocator).`$x`(fieldValueLocatorPattern.format(value)).shouldBe(visible)
  }
}