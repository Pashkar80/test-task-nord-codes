package service

import config.UserConfigData
import domains.ErrorMessageType
import domains.ErrorMessageType.INVALID_CREDENTIAL
import io.qameta.allure.Step
import provider.UserConfigDataProvider
import widgets.LoginWidget

internal class LoginWidgetOperations {
  private val userConfig: UserConfigData = UserConfigDataProvider().readUserConfigData()
  private val loginWidget by lazy { LoginWidget() }

  @Step
  fun fillLoginFormAndSubmit(
    pass: String = userConfig.password!!,
    login: String = userConfig.username!!
  ) {
    loginWidget.apply {
      inputUsernameField(login)
      inputPasswordField(pass)
    }
  }

  @Step
  fun clickLoginButton(expectButtonToDisappear : Boolean = true) {
    loginWidget.clickLoginButton(expectButtonToDisappear)
  }

  @Step
  fun fillLoginFormAutomatically() {
    loginWidget.clickDefaultCredentialLocator()
  }

  @Step
  fun verifyErrorMessageFromIncorrectLogin(message: ErrorMessageType = INVALID_CREDENTIAL) {
    loginWidget.verifyErrorMessage(message)
  }
}