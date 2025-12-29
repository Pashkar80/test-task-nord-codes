package domains

enum class AndroidTagType(val layoutValue: String) {
  EDIT_TEXT_TAG("android.widget.EditText"),
  VIEW_GROUP_TAG("android.view.ViewGroup"),
  TEXT_VIEW_TAG("android.widget.TextView")
}