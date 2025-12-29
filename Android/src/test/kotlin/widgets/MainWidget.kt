package widgets

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.appium.AppiumSelectors.byAttribute
import com.codeborne.selenide.appium.AppiumSelectors.byContentDescription
import com.codeborne.selenide.appium.SelenideAppium.`$`
import elements.AndroidLocators.textViewByText
import elements.ButtonElement.tapButton
import io.appium.java_client.AppiumBy.accessibilityId
import org.openqa.selenium.By

internal class MainWidget : BaseWidget() {
  private val mainMenuButton: By = accessibilityId("open menu")
  private val badgeButton: By = accessibilityId("cart badge")
  private val cartBadge: By = byContentDescription("cart badge")
  val mainMenuBlock by lazy { MainMenuBlock() }

  fun clickMenuButton() {
    tapButton(mainMenuButton, shouldDisappear = false)
  }

  fun verifyIsOnMainWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(mainMenuButton).shouldBe(visible)
  }

  fun clickOnItemByName(itemName: String) {
    tapButton(locator = textViewByText(itemName), shouldDisappear = false)
  }

  fun clickBadgeButton() {
    tapButton(locator = badgeButton, shouldDisappear = false)
  }

  fun verifyItemCount(count: String) {
    `$`(cartBadge).`$`(byAttribute("text", count)).shouldBe(visible)
  }
}