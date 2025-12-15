package tests

import io.appium.java_client.AppiumBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DirectAndroidTest : BaseTest() {

  @Test
  fun `test app functionality`() {
    println("🧪 Тестируем функциональность")

    // 1. Проверяем базовые вещи
    Assertions.assertNotNull(driver.sessionId, "Сессия не активна")

    // 2. Получаем информацию
    val source = driver.pageSource
    println("📄 Page source: ${source.length} символов")
    Assertions.assertTrue(source.isNotEmpty())
    Assertions.assertTrue(source.contains("android"))

    // 3. Ищем элементы
    val elements = driver.findElements(AppiumBy.xpath("//*"))
    println("🔍 Всего элементов: ${elements.size}")

    // 4. Ищем текстовые элементы
    val textElements = driver.findElements(AppiumBy.xpath("//*[@text!='']"))
    println("📝 Текстовых элементов: ${textElements.size}")

    // Выводим первые 5 текстов
    textElements.take(5).forEachIndexed { index, element ->
      println("  ${index + 1}. '${element.text}'")
    }

    // 5. Делаем скриншот
    val screenshot = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE)
    println("📸 Скриншот: ${screenshot.absolutePath}")

    println("🎉 Тест пройден!")
  }

  @Test
  fun `test button click if available`() {
    println("🧪 Тестируем клики")

    // Ищем все кликабельные элементы
    val clickableElements = driver.findElements(
      AppiumBy.xpath("//*[@clickable='true' or @enabled='true']")
    )

    println("🖱 Кликабельных элементов: ${clickableElements.size}")

    if (clickableElements.isNotEmpty()) {
      // Кликаем на первый элемент
      val firstElement = clickableElements.first()
      println("👉 Кликаем на: '${firstElement.text ?: "элемент без текста"}'")

      firstElement.click()
      Thread.sleep(2000)

      // Возвращаемся назад
      driver.navigate().back()
      Thread.sleep(1000)

      println("✅ Клик выполнен успешно")
    } else {
      println("⚠ Кликабельные элементы не найдены")
    }
  }
}