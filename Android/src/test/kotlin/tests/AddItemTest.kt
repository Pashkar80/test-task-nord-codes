package tests

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import service.WidgetOperations

internal class AddItemTest : BaseTest() {
  private val selectedItem: String = "Sauce Labs Backpack"
  private val count: String = "1"
  private lateinit var widgetOperation: WidgetOperations

  @BeforeAll
  fun loginInApp() {
    widgetOperation = WidgetOperations().apply {
      loginWithDefaultCredential()
    }
  }

  @Test
  fun `verify adding item`() {
    widgetOperation.apply {
      mainWidget.openItemCardByName(selectedItem)
      itemWidget.apply {
        verifyIsOnItemWidget(selectedItem)
        addItemToCart()
      }
      mainWidget.verifyItemCountInBadgeAndOpenCartWidget(count)
      cartWidget.apply {
        verifyIsOnCartWidget()
        verifyItemCountAndName(selectedItem, count)
      }
    }
  }
}