package service

import io.qameta.allure.Step
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import widgets.CartWidget

internal class CartWidgetOperations {
  private val title: String = "My Cart"
  private val cartWidget by lazy { CartWidget() }

  @Step
  fun verifyIsOnCartWidget() {
    cartWidget.verifyIsOnCartWidget(title)
  }

  @Step
  fun verifyIsItemsDisplayed(expectedItems: List<String>) {
    val actualItems : List<String> = cartWidget.getCartItemsNames()
    assertEquals(expectedItems.size, actualItems.size, "Incorrect number of items")
    assertTrue(actualItems.containsAll(expectedItems), "Not all items were found in the basket")
  }
}