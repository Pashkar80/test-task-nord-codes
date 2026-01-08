package widgets

import com.codeborne.selenide.appium.SelenideAppium.`$x`
import elements.ButtonElement.tapButton

internal class MainMenuBlock {
  private val mainMenuButtonPattern: String = "//android.widget.TextView[@text='%s']"

  fun clickMainMenuButtonByType(buttonType: menuBlockButtonType) {
    tapButton(`$x`(mainMenuButtonPattern.format(buttonType.buttonName)))
  }

  internal enum class menuBlockButtonType(val buttonName: String) {
    LOGIN("Log In")
  }
}