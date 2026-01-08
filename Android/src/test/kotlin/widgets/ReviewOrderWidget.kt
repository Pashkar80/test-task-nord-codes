package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.AppiumSelectors.byContentDescription
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.ButtonElement.tapButton
import org.openqa.selenium.By

internal class ReviewOrderWidget : BaseWidget() {
  private val placeOrderButton: By = byContentDescription("Place Order button")
  val deliveryAddressBlock by lazy { DeliveryAddressBlock() }
  val paymentMethodBlock by lazy { PaymentMethodBlock() }

  fun verifyIsOnReviewOrderWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(placeOrderButton).shouldBe(Condition.visible)
  }

  fun clickPlaceOrderButton() {
    tapButton(locator = placeOrderButton)
  }
}