package v.sivasubramaniam.calendar.core.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Sail,
    onPrimary = CatalinaBlue,
    secondary = RegalBlue,
    onSecondary = Onahau,
    background = MineShaft,
    onBackground = Mercury,
    surface = MineShaft,
    onSurface = Mercury,
    error = Red80,
    onError = Red20,
)

private val LightColorPalette = lightColors(
    primary = ScienceBlue,
    onPrimary = Color.White,
    secondary = Onahau,
    onSecondary = Midnight,
    background = Color.White,
    onBackground = MineShaft,
    error = Red80,
    onError = Red20,
)

@Composable
fun CalendarTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}