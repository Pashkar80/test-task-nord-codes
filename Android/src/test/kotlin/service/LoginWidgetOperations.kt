package service

import config.UserConfigData
import io.qameta.allure.Step
import provider.UserConfigDataProvider
import screen.LoginWidget

internal class LoginWidgetOperations {
  private val userConfig: UserConfigData = UserConfigDataProvider().readUserConfigData()
  private val loginWidget by lazy { LoginWidget() }

  @Step
  fun fillLoginFormAndSubmit() {
    with(userConfig) {
      loginWidget.apply {
        inputUsernameField(username!!)
        inputPasswordField(password!!)
      }
    }
    clickLoginButton()
  }

  @Step
  fun clickLoginButton() {
    loginWidget.clickLoginButton()
  }

  fun fillLoginFormAutomatically(){
    loginWidget.clickDefaultCredentialLocator()
  }
}