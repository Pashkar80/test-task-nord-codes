package widgets

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.appium.SelenideAppium.`$`
import domains.AndroidTagType.TEXT_VIEW_TAG
import domains.ErrorMessageType
import elements.AndroidLocators.byText
import elements.ButtonElement.tapButton
import elements.InputElement.setInputFieldWithSendKeys
import io.appium.java_client.AppiumBy.accessibilityId
import org.openqa.selenium.By

internal class LoginWidget : BaseWidget() {
  private val usernameField: By = accessibilityId("Username input field")
  private val passwordField: By = accessibilityId("Password input field")
  private val loginButton: By = accessibilityId("Login button")
  private val defaultCredentialLocator: By = By.xpath("//${TEXT_VIEW_TAG.layoutValue}[contains(@text, 'bob')]")

  fun verifyIsOnLoginWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(loginButton).shouldBe(visible)
  }

  fun inputUsernameField(username: String) {
    setInputFieldWithSendKeys(username, usernameField)
  }

  fun inputPasswordField(password: String) {
    setInputFieldWithSendKeys(password, passwordField)
  }

  fun clickLoginButton(expectButtonToDisappear: Boolean = true) {
    tapButton(loginButton, shouldDisappear = expectButtonToDisappear)
  }

  fun clickDefaultCredentialLocator() {
    tapButton(locator = defaultCredentialLocator, shouldDisappear = false)
  }

  fun verifyErrorMessage(message: ErrorMessageType) {
    `$`(byText(message.message)).shouldBe(visible)
  }
}