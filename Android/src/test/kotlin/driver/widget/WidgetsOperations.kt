package driver.widget

import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors.byAttribute
import com.codeborne.selenide.appium.SelenideAppium.`$`
import io.qameta.allure.Step
import org.openqa.selenium.By
import java.time.Duration.ofSeconds

internal class WidgetsOperations {
  private val widgetLoadTimeoutSeconds: Long = 60L
  private val introWidgetLocator: By = byAttribute("resource-id", "com.saucelabs.mydemoapp.rn:id/action_bar_root")

  @Step
  fun verifyStartApplicationWidgetOpened() {
    `$`(introWidgetLocator).shouldBe(visible, ofSeconds(widgetLoadTimeoutSeconds))
  }
}