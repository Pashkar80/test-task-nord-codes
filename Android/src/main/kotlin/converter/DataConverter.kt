package converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullIsSameAsDefault
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullToEmptyCollection
import com.fasterxml.jackson.module.kotlin.KotlinFeature.NullToEmptyMap
import com.fasterxml.jackson.module.kotlin.KotlinFeature.SingletonSupport
import com.fasterxml.jackson.module.kotlin.KotlinFeature.StrictNullChecks
import com.fasterxml.jackson.module.kotlin.KotlinModule

internal object DataConverter {

  fun getKotlinModuleConfig(): KotlinModule {
    return KotlinModule.Builder()
      .withReflectionCacheSize(512)
      .configure(NullToEmptyCollection, false)
      .configure(NullToEmptyMap, false)
      .configure(NullIsSameAsDefault, false)
      .configure(SingletonSupport, false)
      .configure(StrictNullChecks, false)
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