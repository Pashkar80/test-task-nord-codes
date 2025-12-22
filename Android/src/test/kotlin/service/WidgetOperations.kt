package service

internal class WidgetOperations {
  val mainScreen by lazy { MainWidgetOperations() }
  val loginScreen by lazy { LoginWidgetOperations() }
}