package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$x`
import com.codeborne.selenide.appium.SelenideAppium.`$`
import domains.AndroidTagType.EDIT_TEXT_TAG
import elements.AndroidLocators.byText
import elements.InputElement.setInputFieldWithSendKeys

internal abstract class BaseWidget {
  private val checkoutFieldPattern: String =
    "//${EDIT_TEXT_TAG.layoutValue}[@content-desc='%s* input field']"

  protected fun verifyWidgetTitle(title: String) {
    `$`(byText(title)).shouldBe(Condition.visible)
  }

  protected fun fillFieldByType(data: String, fieldType: FieldType) {
    setInputFieldWithSendKeys(data, `$x`(checkoutFieldPattern.format(fieldType.title)))
  }
}