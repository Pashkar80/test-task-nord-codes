package tests

import org.junit.jupiter.api.Test
import service.WidgetOperations

internal class LoginHappyPathTest : BaseTest() {

  @Test
  fun `verify login happy path`() {
    WidgetOperations().apply {
      mainWidget.apply {
        verifyIsOnMainWidget()
        openLoginWidget()
      }
      loginWidget.fillLoginFormAndSubmit()
      mainWidget.verifyIsOnMainWidget()
    }
  }
}