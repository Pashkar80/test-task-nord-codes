package tests

import config.UserConfigData
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import provider.UserConfigDataProvider
import service.CommonOperations.getRandomUniqueItems
import service.WidgetOperations

internal class PurchaseFlowTest : BaseTest() {
  private val items: List<String> = getRandomUniqueItems(1)
  private val userConfig: UserConfigData = UserConfigDataProvider().readUserConfigData()
  private lateinit var widgetOperation: WidgetOperations

  @BeforeAll
  fun loginAndAddItemInBadge() {
    widgetOperation = WidgetOperations().apply {
      loginWithDefaultCredential()
      addItemsToBadge(items)
      mainWidget.openCartWidget()
      cartWidget.apply {
        verifyIsOnCartWidget()
        verifyIsItemsDisplayed(items)
        goToCheckoutWidget()
      }
    }
  }

  @Test
  fun `verify full checkout process`() {
    widgetOperation.apply {
      checkoutWidget.apply {
        verifyIsOnCheckoutWidget()
        fillMandatoryFieldsCheckoutForm(userConfig)
        clickPaymentButton()
      }
      paymentWidget.apply {
        verifyIsOnPaymentWidget()
        fillPaymentForm(userConfig)
        openReviewOrderWidget()
      }
      reviewOrderWidget.apply {
        verifyIsOnReviewOrderWidget()
        verifyDeliveryAddressData(userConfig)
        verifyPaymentMethodData(userConfig)
        clickPlaceOrderButton()
      }
      checkoutCompletedWidget.verifyIsOnCheckoutCompleteWidget()
    }
  }
}