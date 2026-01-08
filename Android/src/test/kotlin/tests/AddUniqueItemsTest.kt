package tests

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import service.CommonOperations.getRandomUniqueItems
import service.WidgetOperations

internal class AddUniqueItemsTest : BaseTest() {
  private val items: List<String> = getRandomUniqueItems(3)
  private lateinit var widgetOperation: WidgetOperations

  @BeforeAll
  fun loginInApp() {
    widgetOperation = WidgetOperations().apply {
      loginWithDefaultCredential()
    }
  }

  @Test
  fun `verify unique adding items`() {
    WidgetOperations().apply {
      addItemsToBadge(items)
      mainWidget.apply {
        verifyItemCountInBadge(items.size.toString())
        openCartWidget()
      }
      cartWidget.apply {
        verifyIsOnCartWidget()
        verifyIsItemsDisplayed(items)
      }
    }
  }
}