package service

import com.codeborne.selenide.appium.ScrollDirection
import io.qameta.allure.Step
import logger.Logger.info
import widgets.MainMenuBlock.menuBlockButtonType.LOGIN
import widgets.MainWidget

internal class MainWidgetOperations {
  private val mainPageTitle: String = "Products"
  private val mainWidget by lazy { MainWidget() }

  @Step
  fun openLoginWidget() {
    info("[Main Widget] Open Login Widget")
    mainWidget.apply {
      clickMenuButton()
      mainMenuBlock.clickMainMenuButtonByType(LOGIN)
    }
  }

  @Step
  fun verifyIsOnMainWidget() {
    info("[Main Widget] [Verification] Is on Main Widget")
    mainWidget.verifyIsOnMainWidget(mainPageTitle)
  }

  @Step
  fun openItemCardByName(itemName: String) {
    info("[Main Widget] Open card by name")
    mainWidget.clickOnItemByName(itemName)
  }

  @Step
  fun verifyItemCountInBadge(count: String) {
    info("[Main Widget] [Verification] Item count in badge ")
    mainWidget.verifyItemCount(count)
  }

  @Step
  fun openCartWidget() {
    info("[Main Widget] Open Cart Widget")
    mainWidget.clickBadgeButton()
  }

  @Step
  fun scrollToTitle(scrollDirection: ScrollDirection) {
    info("[Main Widget] Scroll widget to header")
    mainWidget.scrollToTitle(mainPageTitle, scrollDirection)
  }
}