package tests

import config.UserConfigData
import org.junit.jupiter.api.Test
import provider.UserConfigDataProvider
import service.ScreenOperations

internal class LoginHappyPathTest : BaseTest() {
  private val userConfig: UserConfigData = UserConfigDataProvider().readUserConfigData()

  @Test
  fun `login happy path test`() {
    ScreenOperations().apply {
      mainScreen.apply {
        verifyIsOnMainWidget()
        openLoginWidget()
      }
      loginScreen.fillLoginFormAndSubmit(userConfig.username!!, userConfig.password!!)
      mainScreen.verifyIsOnMainWidget()
    }
  }
}