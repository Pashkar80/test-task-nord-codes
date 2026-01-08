package service

import domains.GoodsType
import io.qameta.allure.Step
import logger.Logger.info
import kotlin.random.Random

internal object CommonOperations {

  @Step
  fun getRandomUniqueItems(count: Int, random: Random = Random.Default): List<String> {
    info("Get random unique items from list")
    val availableCount = GoodsType.entries.size
    require(count in 1..availableCount) {
      """
        Invalid item count: $count.
        Must select between 1 and $availableCount unique items.
        """
    }
    return GoodsType.entries
      .shuffled(random)
      .take(count)
      .map { it.title }
  }
}