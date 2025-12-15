package tests

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.jupiter.api.Test
import java.io.File
import java.net.URL

class CorrectMyDemoAppTest {

  @Test
  fun `test with apk file`() {
    println("🚀 Запускаем MyDemoApp из APK файла")
    println("=".repeat(50))

    try {
      // 1. Проверяем что APK существует
      val apkPath = "src/test/resources/app/MyDemoApp.apk"
      val apkFile = File(apkPath)

      println("🔍 Проверяем APK файл:")
      println("   Путь: ${apkFile.absolutePath}")
      println("   Существует: ${apkFile.exists()}")
      println("   Размер: ${apkFile.length()} байт")

      if (!apkFile.exists()) {
        throw RuntimeException("APK файл не найден: $apkPath")
      }

      // 2. Создаем опции с APK
      val options = UiAutomator2Options()
        .setPlatformName("Android")
        .setDeviceName("Medium Phone")
        .setAutomationName("UiAutomator2")
        .setAutoGrantPermissions(true)
        .setUdid("emulator-5554")
        .setApp(apkFile.absolutePath) // ← КЛЮЧЕВОЕ: указываем APK!

      // 3. Подключаемся к Appium
      val appiumUrl = "http://192.168.56.1:4848/wd/hub"
      println("\n🔌 Подключаемся к Appium: $appiumUrl")
      println("📱 Устанавливаем и запускаем: ${apkFile.name}")

      val driver = AndroidDriver(URL(appiumUrl), options)

      println("✅ ДРАЙВЕР СОЗДАН!")
      println("📱 Session ID: ${driver.sessionId}")

      // 4. Ждем установки и запуска
      println("⏳ Ждем установки и запуска приложения...")
      Thread.sleep(15000) // 15 секунд для установки и запуска

      // 5. Проверяем
      val currentPackage = driver.currentPackage
      println("📦 Текущий пакет: $currentPackage")

      val pageSource = driver.pageSource
      println("📄 Page source: ${pageSource.length} символов")

      if (pageSource.length > 100) {
        println("🎉 MyDemoApp успешно установлен и запущен!")

        // Анализируем что запустилось
        when {
          pageSource.contains("MyDemoApp", ignoreCase = true) ->
            println("✅ Это MyDemoApp")
          pageSource.contains("SauceLabs", ignoreCase = true) ->
            println("✅ Это SauceLabs демо")
          else ->
            println("ℹ Приложение запущено")
        }

        // Поиск элементов
        try {
          val allElements = driver.findElements(
            io.appium.java_client.AppiumBy.xpath("//*")
          )
          println("🔍 Всего элементов: ${allElements.size}")

          val buttons = driver.findElements(
            io.appium.java_client.AppiumBy.className("android.widget.Button")
          )
          println("🔼 Кнопок: ${buttons.size}")

          // Клик по первой кнопке если есть
          if (buttons.isNotEmpty()) {
            println("👉 Кликаем на первую кнопку")
            buttons.first().click()
            Thread.sleep(2000)
          }

        } catch (e: Exception) {
          println("⚠ Не удалось взаимодействовать: ${e.message}")
        }

      } else {
        println("⚠ Page source слишком короткий")
        println("Первые 300 символов:")
        println(pageSource.take(300))
      }

      // 6. Скриншот
      val screenshot = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE)
      println("📸 Скриншот: ${screenshot.absolutePath}")

      // 7. Закрываем
      driver.quit()
      println("🔌 Драйвер закрыт")
      println("\n✅ ТЕСТ УСПЕШНО ЗАВЕРШЕН!")

    } catch (e: Exception) {
      println("\n❌ ОШИБКА: ${e.javaClass.simpleName}")
      println("📝 Сообщение: ${e.message}")

      if (e.message?.contains("signature") == true || e.message?.contains("certificate") == true) {
        println("\n💡 Проблема с подписью APK:")
        println("   Добавьте в capabilities: options.setCapability(\"noSign\", true)")
      }

      throw e
    }
  }
}