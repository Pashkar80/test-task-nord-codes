package screen

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide.`$$`
import domains.AndroidTagType.TEXT_VIEW_TAG
import org.openqa.selenium.By

internal class CartWidget : BaseWidget() {
  private val itemLabelLocator: By = byXpath("//${TEXT_VIEW_TAG.layoutValue}[@content-desc='product label']")

  fun verifyIsOnCartWidget(title: String) {
    verifyWidgetTitle(title)
  }

  fun getCartItemsNames(): List<String> {
    return `$$`(itemLabelLocator).map { it.text() }
  }
}