package codes.hipporasy.sleepsounds.presentation

sealed interface MainRoute {
    data object Discover : MainRoute
    data object Composer : MainRoute
    data object Profile : MainRoute

    val name: String
        get() = when (this) {
            Discover -> "discover"
            Composer -> "composer"
            Profile -> "profile"
        }
}