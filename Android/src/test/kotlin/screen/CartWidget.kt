package screen

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.AndroidLocators.byText

internal class CartWidget : BaseWidget() {

  fun verifyIsOnCartWidget(title : String){
    verifyWidgetTitle(title)
  }

  fun verifyItemName(itemName: String){
    `$`(byText(itemName)).shouldBe(Condition.visible)
  }

  fun verifyItemCount(count: String) {
    `$`(byText(count)).shouldBe(Condition.visible)
  }
}