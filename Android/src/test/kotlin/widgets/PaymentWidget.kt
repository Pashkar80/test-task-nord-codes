package widgets

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.AndroidLocators.byText
import elements.ButtonElement.tapButton
import org.openqa.selenium.By

internal class PaymentWidget : BaseWidget() {
  private val reviewOrderButton: By = byText("Review Order")

  fun verifyIsOnPaymentWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(reviewOrderButton).shouldBe(Condition.visible)
  }

  fun inputDataInPaymentField(data: String, fieldType: PaymentFieldType) {
    fillFieldByType(data, fieldType)
  }

  fun clickReviewOrderButton() {
    tapButton(reviewOrderButton, shouldDisappear = false)
  }

  internal enum class PaymentFieldType(override val title: String) : WidgetFieldType {
    FULL_NAME("Full Name"),
    CARD_NUMBER("Card Number"),
    EXPIRATION_DATE("Expiration Date"),
    SECURITY_CODE("Security Code"),
  }
}