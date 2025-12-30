package tests

import org.junit.jupiter.api.Test
import service.WidgetOperations
import java.lang.Math.random

internal class InvalidPasswordLoginTest : BaseTest() {
  private val invalidPass : String = random().toString()

  @Test
  fun `verify impossible login with incorrect pass`() {
    WidgetOperations().apply {
      mainWidget.apply {
        verifyIsOnMainWidget()
        openLoginWidget()
      }
      loginWidget.apply {
        fillLoginFormAndSubmit(pass = invalidPass)
        clickLoginButton(false)
        verifyErrorMessageFromIncorrectLogin()
      }
    }
  }
}