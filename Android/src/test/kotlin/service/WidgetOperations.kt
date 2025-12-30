package service

import com.codeborne.selenide.appium.SelenideAppium.back

internal class WidgetOperations {
  val mainWidget by lazy { MainWidgetOperations() }
  val loginWidget by lazy { LoginWidgetOperations() }
  val itemWidget by lazy { ItemWidgetOperations() }
  val cartWidget by lazy { CartWidgetOperations() }

  fun loginWithDefaultCredential() {
    mainWidget.openLoginWidget()
    loginWidget.apply {
      fillLoginFormAutomatically()
      clickLoginButton()
    }
  }

  fun addItemsToBadge(itemNames: List<String>) {
    itemNames.forEachIndexed { index, itemName ->
      mainWidget.openItemCardByName(itemName)
      itemWidget.apply {
        verifyIsOnItemWidget(itemName)
        addItemToCart()
      }
      if (index < itemNames.size - 1) {
        back()
        mainWidget.verifyIsOnMainWidget()
      }
    }
  }
}