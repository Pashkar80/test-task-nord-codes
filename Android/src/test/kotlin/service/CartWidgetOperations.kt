package service

import io.qameta.allure.Step
import screen.CartWidget

internal class CartWidgetOperations {
  private val title: String = "My Cart"
  private val cartWidget by lazy { CartWidget() }

  @Step
  fun verifyIsOnCartWidget() {
    cartWidget.verifyIsOnCartWidget(title)
  }

  @Step
  fun verifyItemCountAndName(itemName: String, count: String) {
    cartWidget.apply {
      verifyItemName(itemName)
      verifyItemCount(count)
    }
  }
}