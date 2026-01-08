package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.AppiumSelectors.byContentDescription
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.ButtonElement.tapButton
import org.openqa.selenium.By

internal class CheckoutWidget : BaseWidget() {
  private val paymentButton: By = byContentDescription("To Payment button")

  fun verifyIsOnCheckoutWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(paymentButton).shouldBe(Condition.visible)
  }

  fun inputDataInCheckoutField(data: String, fieldType: CheckoutFieldType) {
    fillFieldByType(data, fieldType)
  }

  fun clickPaymentButton() {
    tapButton(paymentButton)
  }

  internal enum class CheckoutFieldType(override val title: String) : FieldType {
    FULL_NAME("Full Name"),
    ADDRESS_LINE("Address Line 1"),
    CITY("City"),
    ZIP_CODE("Zip Code"),
    COUNTRY("Country")
  }
}