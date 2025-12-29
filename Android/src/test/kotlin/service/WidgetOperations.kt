package service

internal class WidgetOperations {
  val mainWidget by lazy { MainWidgetOperations() }
  val loginWidget by lazy { LoginWidgetOperations() }
  val itemWidget by lazy { ItemWidgetOperations() }
  val cartWidget by lazy { CartWidgetOperations() }

  fun loginWithDefaultCredential() {
    mainWidget.openLoginWidget()
    loginWidget.apply {
      fillLoginFormAutomatically()
      clickLoginButton()
    }
  }
}