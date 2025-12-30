package widgets

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.appium.SelenideAppium.`$`
import domains.AndroidTagType.TEXT_VIEW_TAG
import domains.AndroidTagType.VIEW_GROUP_TAG
import elements.AndroidLocators.textViewByText
import elements.ButtonElement.tapButton
import io.appium.java_client.AppiumBy.accessibilityId
import org.openqa.selenium.By

internal class MainWidget : BaseWidget() {
  private val mainMenuButton: By = accessibilityId("open menu")
  private val badgeButton: By = By.xpath("//${VIEW_GROUP_TAG.layoutValue}[@content-desc='cart badge']")
  private val itemCounterPattern: String = ".//${TEXT_VIEW_TAG.layoutValue}[@text='%s']"
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
    `$`(badgeButton).`$x`(itemCounterPattern.format(count)).shouldBe(visible)
  }
}