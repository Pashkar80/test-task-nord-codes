package provider

import config.UserConfigData
import converter.DataConverter.resourceFileToObject

internal class UserConfigDataProvider {

  fun readUserConfigData(): UserConfigData {
    val filePath = "testdata/defaultUserData.yaml"
    return resourceFileToObject(filePath, UserConfigData::class.java)
  }
}