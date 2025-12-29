package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.AndroidLocators.byText

internal abstract class BaseWidget {

  protected fun verifyWidgetTitle(title : String){
    `$`(byText(title)).shouldBe(Condition.visible)
  }
}