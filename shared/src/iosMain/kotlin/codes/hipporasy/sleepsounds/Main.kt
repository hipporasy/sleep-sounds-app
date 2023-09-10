package codes.hipporasy.sleepsounds

import androidx.compose.runtime.Composable
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.window.ComposeUIViewController

object Main {
    val controller = ComposeUIViewController { App() }
}

