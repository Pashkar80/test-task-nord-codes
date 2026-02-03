package widgets

import domains.AndroidTagType.VIEW_GROUP_TAG
import org.openqa.selenium.By

internal class PaymentMethodBlock : BaseBlock() {
  override val baseBlockLocator: By =
    By.xpath("//${VIEW_GROUP_TAG.layoutValue}[@content-desc='checkout payment info']")
}