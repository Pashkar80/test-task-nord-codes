package config

internal data class UserConfigData(
  var username: String? = null,
  var password: String? = null,
  var fullName: String? = null,
  var addressLine: String? = null,
  var city: String? = null,
  var zipCode: String? = null,
  var country: String? = null,
  var cardData: CardData? = null
)

internal data class CardData(
  var cardNumber: String? = null,
  var expirationDate: String? = null,
  var code: String? = null
)