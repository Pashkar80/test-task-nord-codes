package screen

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import com.codeborne.selenide.appium.SelenideAppium.`$x`
import domains.AndroidTagType.TEXT_VIEW_TAG
import domains.AndroidTagType.VIEW_GROUP_TAG
import elements.AndroidLocators.textViewByText
import elements.ButtonElement.tapButton
import io.appium.java_client.AppiumBy.accessibilityId

internal class MainWidget : BaseWidget() {
  private val mainMenuButton = accessibilityId("open menu")
  private val badgeButton = accessibilityId("cart badge")
  private val badgeItemCountPattern: String =
    "//${VIEW_GROUP_TAG.layoutValue}[@content-desc='cart badge']/${TEXT_VIEW_TAG.layoutValue}[@text='%s']"
  val mainMenuBlock by lazy { MainMenuBlock() }

  fun clickMenuButton() {
    tapButton(mainMenuButton, shouldDisappear = false)
  }

  fun verifyIsOnMainWidget(title: String) {
    verifyWidgetTitle(title)
    `$`(mainMenuButton).shouldBe(Condition.visible)
  }

  fun clickOnItemByName(itemName: String) {
    tapButton(locator = textViewByText(itemName), shouldDisappear = false)
    // TODO переделать на то чтобы подавать сюда список товаров просто для этого случая товар один
  }

  fun clickBadgeButton() {
    tapButton(locator = badgeButton, shouldDisappear = false)
  }

  fun verifyItemCount(count: String) {
    `$x`(badgeItemCountPattern.format(count)).shouldBe(Condition.visible)
  }
}