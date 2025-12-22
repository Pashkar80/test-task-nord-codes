package driver.widget

import com.codeborne.selenide.Condition
import com.codeborne.selenide.appium.SelenideAppium.`$`
import io.qameta.allure.Step
import org.openqa.selenium.By
import java.time.Duration

internal class WidgetsOperations {
  private val widgetLoadTimeoutSeconds: Long = 60L
  private val introWidgetLocator: By = By.xpath("//*[@resource-id='com.saucelabs.mydemoapp.rn:id/action_bar_root']")

  @Step
  fun verifyStartApplicationWidgetOpened() {
    `$`(introWidgetLocator).shouldBe(Condition.visible, Duration.ofSeconds(widgetLoadTimeoutSeconds))
  }

}