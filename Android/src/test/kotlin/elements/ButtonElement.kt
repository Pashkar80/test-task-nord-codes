package elements



import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.AppiumClickOptions.tap
import com.codeborne.selenide.appium.SelenideAppium.`$`
import org.openqa.selenium.By

internal object ButtonElement {

  fun tapButton(
    locator: SelenideElement,
    shouldScrollTo: Boolean = false,
    shouldDisappear: Boolean = true,
  ) {
    locator.apply {
      if (shouldScrollTo) scrollTo()
      shouldBe(Condition.visible, Condition.enabled)
      click(tap())
      if (shouldDisappear) shouldBe(Condition.disappear)
    }
  }

  fun tapButton(
    locator: By,
    shouldScrollTo: Boolean = false,
    shouldDisappear: Boolean = true
  ) {
   tapButton(`$`(locator), shouldScrollTo, shouldDisappear)
  }
}