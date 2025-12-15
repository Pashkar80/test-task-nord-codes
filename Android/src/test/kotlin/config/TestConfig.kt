package tests.config

import org.aeonbits.owner.Config
import org.aeonbits.owner.Config.DefaultValue
import org.aeonbits.owner.Config.Key

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(
  "system:properties",
  "file:src/test/resources/configs/test.properties"
)
internal interface TestConfig : Config {

  @Key("deviceHost")
  fun deviceHost(): String?

  @Key("updateScreenshots")
  @DefaultValue("false")
  fun updateScreenshots(): Boolean?
}