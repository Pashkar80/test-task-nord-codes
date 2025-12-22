package config

internal data class EmulatorConfigData(
  var deviceName: String?,
  var platformName: String?,
  var appPackage: String?,
  var appActivity: String?,
  var remoteURL: String?,
  var app: String?,
  var version: String?
)