package widgets

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.appium.AppiumSelectors.byContentDescription
import elements.AndroidLocators.byText
import elements.ButtonElement.tapButton
import org.openqa.selenium.By

internal class CartWidget : BaseWidget() {
  private val itemLabelLocator: By = byContentDescription("product label")
  private val proceedCheckoutButton: By = byText("Proceed To Checkout")

  fun verifyIsOnCartWidget(title: String) {
    verifyWidgetTitle(title)
  }

  fun getCartItemsNames(): List<String> {
    return `$$`(itemLabelLocator).map { it.text() }
  }

  fun clickProceedCheckoutButton(){
    tapButton(proceedCheckoutButton, shouldDisappear = false)
  }
}