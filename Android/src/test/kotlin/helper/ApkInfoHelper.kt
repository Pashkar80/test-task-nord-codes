package tests.helper

import tests.config.ConfigReader
import java.io.IOException
import java.util.concurrent.ExecutionException

internal class ApkInfoHelper {
//  private var apkInfo: String
//
// constructor() {
//    val app = ConfigReader.emulatorConfig.app() //читаем путь к apk из пропертей
//    if (app == null || app.isEmpty()) { //если путь к apk файлу не указан, выкидываем ошибку
//      throw RuntimeException("No value for key 'app' providing apk path in emulator.yaml")
//    }
//    try {
//      //вызываем bash команду aapt dumb banding путь к apk, чтобы прочитать AndroidManifest.xml из apk файла
//      apkInfo = DeviceHelper().executeSh("aapt dumb badging " + ConfigReader.emulatorConfig.app()).toString()
//    } catch (e: IOException) {
//      throw RuntimeException(e)
//    } catch (e: InterruptedException) {
//      throw RuntimeException(e)
//    } catch (e: ExecutionException) {
//      throw RuntimeException(e)
//    }
//  }
}