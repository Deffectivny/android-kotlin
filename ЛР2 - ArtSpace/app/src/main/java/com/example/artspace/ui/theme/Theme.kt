package com.example.artspace.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Определим цвета для темы
private val LightColors = lightColorScheme(
    primary = Color(0xFF6A1B9A), // фиолетовый (исп.)
    secondary = Color(0xFF4CAF50), // зелёный
    tertiary = Color(0xFFFFC107), // жёлтый
    background = Color(0xFFF0F4C3), // светло-зелёный
    surface = Color(0xFFBBDEFB),  // голубой для фона (исп.)
    onSurface = Color(0xFF333333), // темно-серый для автор+год (исп.)
)

@Composable
fun artSpaceAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
