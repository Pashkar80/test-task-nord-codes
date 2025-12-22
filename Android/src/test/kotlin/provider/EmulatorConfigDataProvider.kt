package provider

import converter.DataConverter.resourceFileToObject
import config.EmulatorConfigData
import kotlin.jvm.java

internal class EmulatorConfigDataProvider {

  fun readEmulatorConfigData(): EmulatorConfigData {
    val filePath = "config/emulator.yaml"
    return resourceFileToObject(filePath, EmulatorConfigData::class.java)
  }
}