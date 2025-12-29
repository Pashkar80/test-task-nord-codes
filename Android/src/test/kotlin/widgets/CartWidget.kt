package widgets

import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.appium.AppiumSelectors.byContentDescription
import org.openqa.selenium.By

internal class CartWidget : BaseWidget() {
  private val itemLabelLocator: By = byContentDescription("product label")

  fun verifyIsOnCartWidget(title: String) {
    verifyWidgetTitle(title)
  }

  fun getCartItemsNames(): List<String> {
    return `$$`(itemLabelLocator).map { it.text() }
  }
}