package domains

internal enum class ErrorMessageType (val message: String) {
  INVALID_CREDENTIAL("Provided credentials do not match any user in this service.")
}