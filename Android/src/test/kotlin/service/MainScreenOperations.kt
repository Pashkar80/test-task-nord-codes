package service

import io.qameta.allure.Step
import screen.MainMenuBlock
import screen.MainWidget

internal class MainScreenOperations {
  private val mainWidget by lazy { MainWidget() }

  @Step
  fun openLoginWidget() {
    mainWidget.apply {
      clickMenuButton()
      mainMenuBlock.clickMainMenuButtonByType(MainMenuBlock.mainMenuBlockButtonType.LOGIN)
    }
  }

  @Step
  fun verifyIsOnMainWidget() {
    mainWidget.verifyIsOnMainScreen()
  }
}