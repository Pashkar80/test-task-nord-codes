package tests

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import service.WidgetOperations

internal class AddItemsTest : BaseTest() {
  private val items: List<String> = listOf(
    "Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Fleece Jacket"
  )
  private lateinit var widgetOperation: WidgetOperations

  @BeforeAll
  fun loginInApp() {
    widgetOperation = WidgetOperations().apply {
      loginWithDefaultCredential()
    }
  }

  @Test
  fun `verify adding items`() {
    widgetOperation.apply {
      addItemsToBadge(items)
      mainWidget.verifyItemCountInBadgeAndOpenCartWidget(items.size.toString())
      cartWidget.apply {
        verifyIsOnCartWidget()
        verifyIsItemsDisplayed(items)
      }
    }
  }
}