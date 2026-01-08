package tests

import org.junit.jupiter.api.Test
import service.WidgetOperations
import kotlin.random.Random.Default.nextLong

internal class InvalidPasswordLoginTest : BaseTest() {
  private val invalidPass: String = nextLong(1000000, 9999999).toString()

  @Test
  fun `verify impossible login with incorrect pass`() {
    WidgetOperations().apply {
      mainWidget.apply {
        verifyIsOnMainWidget()
        openLoginWidget()
      }
      loginWidget.apply {
        verifyIsOnLoginWidget()
        fillLoginFormAndSubmit(pass = invalidPass)
        clickLoginButton(false)
        verifyErrorMessageFromIncorrectLogin()
      }
    }
  }
}