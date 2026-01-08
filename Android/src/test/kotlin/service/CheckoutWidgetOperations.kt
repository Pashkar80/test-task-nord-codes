package service

import config.UserConfigData
import io.qameta.allure.Step
import logger.Logger.info
import widgets.CheckoutWidget
import widgets.CheckoutWidget.CheckoutFieldType.ADDRESS_LINE
import widgets.CheckoutWidget.CheckoutFieldType.CITY
import widgets.CheckoutWidget.CheckoutFieldType.COUNTRY
import widgets.CheckoutWidget.CheckoutFieldType.FULL_NAME
import widgets.CheckoutWidget.CheckoutFieldType.ZIP_CODE

internal class CheckoutWidgetOperations {
  private val title: String = "Checkout"
  private val checkoutWidget by lazy { CheckoutWidget() }

  @Step
  fun verifyIsOnCheckoutWidget() {
    info("[Checkout Widget] [Verification] Is on Checkout Widget")
    checkoutWidget.verifyIsOnCheckoutWidget(title)
  }

  @Step
  fun fillMandatoryFieldsCheckoutForm(userConfig: UserConfigData) {
    info("[Checkout Widget] Fill mandatory fields in checkout form")
    with(userConfig) {
      checkoutWidget.apply {
        inputDataInCheckoutField(fullName!!, FULL_NAME)
        inputDataInCheckoutField(city!!, CITY)
        inputDataInCheckoutField(addressLine!!, ADDRESS_LINE)
        inputDataInCheckoutField(zipCode!!, ZIP_CODE)
        inputDataInCheckoutField(country!!, COUNTRY)
      }
    }
  }

  @Step
  fun clickPaymentButton() {
    info("[Checkout Widget] Click payment button")
    checkoutWidget.clickPaymentButton()
  }
}