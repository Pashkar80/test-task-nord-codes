package service

import io.qameta.allure.Step
import logger.Logger.info
import widgets.ItemWidget

internal class ItemWidgetOperations {
  private val itemWidget by lazy { ItemWidget() }

  @Step
  fun verifyIsOnItemWidget(itemName: String) {
    info("[Item Widget] [Verification] Is on Item Widget")
    itemWidget.verifyIsOnItemWidget(itemName)
  }

  @Step
  fun addItemToCart() {
    info("[Item Widget] Add item to cart")
    itemWidget.clickAddButton()
    }
  }