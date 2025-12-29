package service

import io.qameta.allure.Step
import widgets.ItemWidget

internal class ItemWidgetOperations {
  private val itemWidget by lazy { ItemWidget() }

  @Step
  fun verifyIsOnItemWidget(itemName: String) {
    itemWidget.verifyIsOnItemWidget(itemName)
  }

  @Step
  fun addItemToCart() {
    itemWidget.clickAddButton()
    }
  }