package converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

object DataConverter {

  fun getKotlinModuleConfig(): KotlinModule {
    return KotlinModule.Builder()
      .withReflectionCacheSize(512)
      .configure(KotlinFeature.NullToEmptyCollection, false)
      .configure(KotlinFeature.NullToEmptyMap, false)
      .configure(KotlinFeature.NullIsSameAsDefault, false)
      .configure(KotlinFeature.SingletonSupport, false)
      .configure(KotlinFeature.StrictNullChecks, false)
      .build()
  }

  fun <T> resourceFileToObject(filePath: String, objectClass: Class<T>): T {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)?.use {
      ObjectMapper(YAMLFactory())
        .registerModule(getKotlinModuleConfig())
        .readValue(it, objectClass)
    } ?: throw IllegalArgumentException("File not found for selected path $filePath for ${objectClass.simpleName}")
  }
}