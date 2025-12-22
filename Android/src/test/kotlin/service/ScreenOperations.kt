package service

internal class ScreenOperations {
  val mainScreen by lazy { MainScreenOperations() }
  val loginScreen by lazy { LoginScreenOperations() }
}