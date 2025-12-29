package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.AndroidLocators.byText
import elements.ButtonElement.tapButton
import org.openqa.selenium.By

internal class ItemWidget : BaseWidget() {
  private val addButton: By = byText("Add To Cart")

  fun verifyIsOnItemWidget(itemName: String) {
    verifyWidgetTitle(itemName)
    `$`(addButton).shouldBe(Condition.visible)
  }

  fun clickAddButton() {
    tapButton(locator = addButton, shouldDisappear = false)
  }
}