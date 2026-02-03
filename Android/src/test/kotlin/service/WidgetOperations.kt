package service

import com.codeborne.selenide.appium.ScrollDirection.DOWN
import com.codeborne.selenide.appium.SelenideAppium.back
import io.qameta.allure.Step
import logger.Logger.info

internal class WidgetOperations {
  val mainWidget by lazy { MainWidgetOperations() }
  val loginWidget by lazy { LoginWidgetOperations() }
  val itemWidget by lazy { ItemWidgetOperations() }
  val cartWidget by lazy { CartWidgetOperations() }
  val checkoutWidget by lazy { CheckoutWidgetOperations() }
  val paymentWidget by lazy { PaymentWidgetOperations() }
  val checkoutCompletedWidget by lazy { CheckoutCompletedWidgetOperations() }
  val reviewOrderWidget by lazy { ReviewOrderWidgetOperations() }

  @Step
  fun loginWithDefaultCredential() {
    info("Login with default credential")
    mainWidget.openLoginWidget()
    loginWidget.apply {
      fillLoginFormAutomatically()
      clickLoginButton()
    }
  }

  @Step
  fun addItemsToBadge(itemNames: List<String>) {
    info("Add unique items to tye badge")
    itemNames.forEachIndexed { index, itemName ->
      mainWidget.openItemCardByName(itemName)
      itemWidget.apply {
        verifyIsOnItemWidget(itemName)
        addItemToCart()
      }
      if (index < itemNames.size - 1) {
        back()
        mainWidget.apply {
          scrollToTitle(DOWN)
          verifyIsOnMainWidget()
        }
      }
    }
  }
}