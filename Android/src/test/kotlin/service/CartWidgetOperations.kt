package service

import io.qameta.allure.Step
import logger.Logger.info
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import widgets.CartWidget

internal class CartWidgetOperations {
  private val title: String = "My Cart"
  private val cartWidget by lazy { CartWidget() }

  @Step
  fun verifyIsOnCartWidget() {
    info("[Cart Widget] [Verification] Is on Cart Widget")
    cartWidget.verifyIsOnCartWidget(title)
  }

  @Step
  fun verifyIsItemsDisplayed(expectedItems: List<String>) {
    info("[Cart Widget] [Verification] Is items displayed")
    val actualItems : List<String> = cartWidget.getCartItemsNames()
    assertEquals(expectedItems.size, actualItems.size, "Incorrect number of items")
    assertTrue(actualItems.containsAll(expectedItems), "Not all items were found in the basket")
  }

  @Step
  fun goToCheckoutWidget(){
    info("[Cart Widget] Go to Checkout Widget")
    cartWidget.clickProceedCheckoutButton()
  }
}