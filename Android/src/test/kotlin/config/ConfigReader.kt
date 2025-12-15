package tests.config

import org.aeonbits.owner.ConfigFactory

object ConfigReader {


  internal val testConfig : TestConfig = ConfigFactory.create(
    TestConfig:: class.java, System.getProperties())

}