package service

import config.UserConfigData
import io.qameta.allure.Step
import logger.Logger.info
import widgets.ReviewOrderWidget

internal class ReviewOrderWidgetOperations {
  private val title: String = "Review your order"
  private val expirationDatePattern: String = "Exp: %s"
  private val reviewOrderWidget by lazy { ReviewOrderWidget() }

  @Step
  fun verifyIsOnReviewOrderWidget() {
    info("[Review Order Widget] [Verification] Is on Review Order Widget")
    reviewOrderWidget.verifyIsOnReviewOrderWidget(title)
  }

  @Step
  fun clickPlaceOrderButton() {
    reviewOrderWidget.clickPlaceOrderButton()
  }

  @Step
  fun verifyDeliveryAddressData(userConfig: UserConfigData) {
    info("[Review Order Widget] Delivery address data")
    with(userConfig) {
      reviewOrderWidget.deliveryAddressBlock.apply {
        verifyFieldWithTextIsVisible(fullName!!)
        verifyFieldWithTextIsVisible(addressLine!!)
        verifyFieldWithTextIsVisible(city!!)
        verifyFieldWithTextIsVisible("$country, $zipCode")
      }
    }
  }

  @Step
  fun verifyPaymentMethodData(userConfig: UserConfigData) {
    info("[Review Order Widget] [Verification] Payment method data")
    with(userConfig) {
      reviewOrderWidget.paymentMethodBlock.apply {
        verifyFieldWithTextIsVisible(fullName!!)
        verifyFieldWithTextIsVisible(cardData!!.cardNumber!!)
        verifyFieldWithTextIsVisible(expirationDatePattern.format(cardData!!.expirationDate!!))
      }
    }
  }
}