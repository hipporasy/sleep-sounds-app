package codes.hipporasy.sleepsounds.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SleepTheme(
    content: @Composable () -> Unit
) {
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )

    MaterialTheme(
        colorScheme = colorScheme.copy(
            primary = Color(0xFF4870FF),
            secondary = Color(0xFF21283F),
            onSecondary = Color(0xFF4870FF),
            onPrimary = Color(0xFFFFFFFF),
            onSurfaceVariant = Color(0xFFFFFFFF).copy(alpha = 0.7f),
            surface = Color(0xFF21283F),
            background = Color(0xFF141927)
        ),
        typography = typography,
        content = content
    )
}
