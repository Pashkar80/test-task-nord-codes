package tests

import driver.DriverManager
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS

@TestInstance(PER_CLASS)
 internal  abstract class BaseTest {
  protected lateinit var driver: AndroidDriver

  @BeforeAll
  fun setUp() {
    driver = DriverManager.initDriver()
    Thread.sleep(7000)
  }

   @AfterAll
   fun tearDown() {
     if (::driver.isInitialized) {
       DriverManager.quitDriver()
     }
   }

}