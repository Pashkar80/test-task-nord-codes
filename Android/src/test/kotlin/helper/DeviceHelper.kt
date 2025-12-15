package tests.helper

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.FutureTask
import java.util.stream.Collectors

internal class DeviceHelper {

  @Throws(IOException::class, ExecutionException::class, InterruptedException::class)
  fun executeSh(command: String?): String? {
    val p = Runtime.getRuntime().exec(command) //получаем инстатс терминала и выполняем скрипт
    val future = FutureTask<String?>(Callable {
      BufferedReader(InputStreamReader(p.getInputStream())) //читаем поток информации из консоли
        .lines().map<String?> { obj: String? -> obj.toString() }  //информацию преобразуем в строку
        .collect(Collectors.joining("\n")) //все строки собираем в одну с разделением в виде новой строки
    })
    Thread(future).start() //запускаем поток
    return future.get() //ждем завершения CallBack для получения полной конечной информации из консоли
  }
}