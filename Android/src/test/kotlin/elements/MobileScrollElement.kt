package elements

import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.appium.ScrollDirection
import com.codeborne.selenide.appium.ScrollDirection.DOWN
import com.codeborne.selenide.appium.ScrollDirection.UP
import com.codeborne.selenide.appium.SelenideAppium.`$`
import driver.DriverManager
import org.openqa.selenium.By
import org.openqa.selenium.interactions.PointerInput
import org.openqa.selenium.interactions.Sequence
import java.time.Duration

internal object MobileScrollElement {

  fun SelenideElement.scrollToVisibility(direction: ScrollDirection) {
    if (!this.isDisplayed) {
      scroll(direction)
    }
  }

  fun By.scrollToVisibility(direction: ScrollDirection = DOWN) {
    `$`(this).scrollToVisibility(direction)
  }

  private fun scroll(direction: ScrollDirection, durationMs: Long = 200) {
    val driver = DriverManager.getCurrentDriver()
    val size = driver.manage().window().size
    val (startX, startY, endX, endY) = when (direction) {
      UP -> {
        arrayOf(
          size.width / 2,
          (size.height * 0.8).toInt(),
          size.width / 2,
          (size.height * 0.2).toInt()
        )
      }

      DOWN -> {
        arrayOf(
          size.width / 2,
          (size.height * 0.2).toInt(),
          size.width / 2,
          (size.height * 0.8).toInt()
        )
      }
    }
    val finger = PointerInput(PointerInput.Kind.TOUCH, "finger")
    val sequence = Sequence(finger, 0)
    sequence.addAction(
      finger.createPointerMove(
        Duration.ZERO,
        PointerInput.Origin.viewport(),
        startX,
        startY
      )
    )
    sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
    sequence.addAction(
      finger.createPointerMove(
        Duration.ofMillis(durationMs),
        PointerInput.Origin.viewport(),
        endX,
        endY
      )
    )
    sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
    driver.perform(listOf(sequence))
  }
}