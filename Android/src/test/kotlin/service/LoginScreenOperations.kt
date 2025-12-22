package service

import screen.LoginWidget

internal class LoginScreenOperations {
  private val loginWidget by lazy { LoginWidget() }

  fun fillLoginFormAndSubmit(username: String, password: String) {
    loginWidget.apply {
      inputUsernameField(username)
      inputPasswordField(password)
      clickLoginButton()
    }
  }
}