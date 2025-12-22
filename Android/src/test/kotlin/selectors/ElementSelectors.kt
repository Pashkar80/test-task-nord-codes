package selectors

import com.codeborne.selenide.appium.AppiumSelectors.byTagAndContentDescription
import domains.AndroidTagType
import org.openqa.selenium.By

internal object ElementSelectors {

  fun byTagAndContentDescription(tag: AndroidTagType, contentDescriptionValue: String): By {
    return byTagAndContentDescription(tag.layoutValue, contentDescriptionValue)
  }
}