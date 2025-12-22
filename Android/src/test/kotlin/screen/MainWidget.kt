package screen

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.ButtonElement.tapButton
import elements.Locators.byText
import io.appium.java_client.AppiumBy.accessibilityId

internal class MainWidget {
  private val mainMenuButton = accessibilityId("open menu")
  private val mainPageTitle: String = "Products"
  val mainMenuBlock by lazy { MainMenuBlock() }

  fun clickMenuButton() {
    tapButton(mainMenuButton, shouldDisappear = false)
  }

  fun verifyIsOnMainScreen() {
    `$`(byText(mainPageTitle)).shouldBe(Condition.visible)
    `$`(mainMenuButton).shouldBe(Condition.visible)
  }
}