package service

import config.UserConfigData
import io.qameta.allure.Step
import logger.Logger.info
import widgets.PaymentWidget
import widgets.PaymentWidget.PaymentFieldType.CARD_NUMBER
import widgets.PaymentWidget.PaymentFieldType.EXPIRATION_DATE
import widgets.PaymentWidget.PaymentFieldType.FULL_NAME
import widgets.PaymentWidget.PaymentFieldType.SECURITY_CODE

internal class PaymentWidgetOperations {
  private val title: String = "Card"
  private val paymentWidget by lazy { PaymentWidget() }

  @Step
  fun verifyIsOnPaymentWidget() {
    info("[Payment Widget] [Verification] Is on Payment Widget")
    paymentWidget.verifyIsOnPaymentWidget(title)
  }

  @Step
  fun fillPaymentForm(userConfig: UserConfigData) {
    info("[Payment Widget] Fill payment form")
    with(userConfig) {
      paymentWidget.apply {
        inputDataInPaymentField(fullName!!, FULL_NAME)
        inputDataInPaymentField(cardData!!.cardNumber!!, CARD_NUMBER)
        inputDataInPaymentField(cardData!!.expirationDate!!, EXPIRATION_DATE)
        inputDataInPaymentField(cardData!!.code!!, SECURITY_CODE)
      }
    }
  }

  @Step
  fun openReviewOrderWidget(){
    info("[Payment Widget] Open Review Order Widget")
    paymentWidget.clickReviewOrderButton()
  }
}