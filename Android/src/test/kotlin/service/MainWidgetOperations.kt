package service

import io.qameta.allure.Step
import widgets.MainMenuBlock.mainMenuBlockButtonType.LOGIN
import widgets.MainWidget

internal class MainWidgetOperations {
  private val mainPageTitle: String = "Products"
  private val mainWidget by lazy { MainWidget() }

  @Step
  fun openLoginWidget() {
    mainWidget.apply {
      clickMenuButton()
      mainMenuBlock.clickMainMenuButtonByType(LOGIN)
    }
  }

  @Step
  fun verifyIsOnMainWidget() {
    mainWidget.verifyIsOnMainWidget(mainPageTitle)
  }

  @Step
  fun openItemCardByName(itemName: String) {
    mainWidget.clickOnItemByName(itemName)
  }

  @Step
  fun verifyItemCountInBadgeAndOpenCartWidget(count: String) {
    mainWidget.apply {
      verifyItemCount(count)
      clickBadgeButton()
    }
  }
}