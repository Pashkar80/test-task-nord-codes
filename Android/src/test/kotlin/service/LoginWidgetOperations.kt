package service

import config.UserConfigData
import domains.ErrorMessageType
import domains.ErrorMessageType.INVALID_CREDENTIAL
import io.qameta.allure.Step
import logger.Logger.info
import provider.UserConfigDataProvider
import widgets.LoginWidget

internal class LoginWidgetOperations {
  private val title : String = "Login"
  private val userConfig: UserConfigData = UserConfigDataProvider().readUserConfigData()
  private val loginWidget by lazy { LoginWidget() }

  @Step
  fun verifyIsOnLoginWidget(){
    info("[Login Widget] [Verification] Is on Login Widget")
    loginWidget.verifyIsOnLoginWidget(title)
  }

  @Step
  fun fillLoginFormAndSubmit(
    pass: String = userConfig.password!!,
    login: String = userConfig.username!!
  ) {
    info("[Login Widget] Fill login form and submit")
    loginWidget.apply {
      inputUsernameField(login)
      inputPasswordField(pass)
    }
  }

  @Step
  fun clickLoginButton(expectButtonToDisappear : Boolean = true) {
    info("[Login Widget] Click login button")
    loginWidget.clickLoginButton(expectButtonToDisappear)
  }

  @Step
  fun fillLoginFormAutomatically() {
    info("[Login Widget] Fill login form automatically")
    loginWidget.clickDefaultCredentialLocator()
  }

  @Step
  fun verifyErrorMessageFromIncorrectLogin(message: ErrorMessageType = INVALID_CREDENTIAL) {
    info("[Login Widget] [Verification] Error message from incorrect login")
    loginWidget.verifyErrorMessage(message)
  }
}