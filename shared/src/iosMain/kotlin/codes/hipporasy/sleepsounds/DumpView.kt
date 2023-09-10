@file:OptIn(ExperimentalForeignApi::class)

package codes.hipporasy.sleepsounds

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIView

object DumpViewInjector {
    lateinit var viewFactory: () -> UIView

    fun setView(factory: () -> UIView) {
        viewFactory = factory
    }

}

@Composable
actual fun DumpView() {
    UIKitView(
        factory = {
            DumpViewInjector.viewFactory()
        },
        modifier = Modifier.fillMaxWidth().height(50.dp),
    )
}