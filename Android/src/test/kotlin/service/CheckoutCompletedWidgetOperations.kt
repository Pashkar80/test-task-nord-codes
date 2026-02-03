package service

import io.qameta.allure.Step
import logger.Logger.info
import widgets.CheckoutCompletedWidget

internal class CheckoutCompletedWidgetOperations {
  private val title: String = "Checkout Complete"
  private val checkoutCompleteWidget by lazy { CheckoutCompletedWidget() }

  @Step
  fun verifyIsOnCheckoutCompleteWidget() {
    info("[Checkout Completed Widget] [Verification] Is on Checkout Completed Widget")
    checkoutCompleteWidget.verifyIsOnCheckoutCompleteWidget(title)
  }
}