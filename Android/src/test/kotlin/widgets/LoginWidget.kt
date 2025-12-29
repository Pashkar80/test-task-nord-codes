package widgets

import domains.AndroidTagType.TEXT_VIEW_TAG
import elements.ButtonElement.tapButton
import elements.InputElement.setInputFieldWithSendKeys
import io.appium.java_client.AppiumBy.accessibilityId
import org.openqa.selenium.By

internal class LoginWidget {
  private val usernameField: By = accessibilityId("Username input field")
  private val passwordField: By = accessibilityId("Password input field")
  private val loginButton: By = accessibilityId("Login button")
  private val defaultCredentialLocator: By = By.xpath("//${TEXT_VIEW_TAG.layoutValue}[contains(@text, 'bob')]")

  fun inputUsernameField(username: String) {
    setInputFieldWithSendKeys(username, usernameField)
  }

  fun inputPasswordField(password: String) {
    setInputFieldWithSendKeys(password, passwordField)
  }

  fun clickLoginButton() {
    tapButton(loginButton)
  }

  fun clickDefaultCredentialLocator() {
    tapButton(locator = defaultCredentialLocator, shouldDisappear = false)
  }
}