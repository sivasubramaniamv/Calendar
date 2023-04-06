package v.sivasubramaniam.calendar.core.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import v.sivasubramaniam.calendar.R

val Inter = FontFamily(
    Font(R.font.inter)
)

val RedHatDisplay = FontFamily(
    Font(R.font.red_hat_display)
)

// Set of Material typography styles to start with
val Typography = Typography(

    h5 = TextStyle(
        color = Pumice,
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    subtitle1 = TextStyle(
        color = Mercury,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    body1 = TextStyle(
        color = Mercury,
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    caption = TextStyle(
        color = Pumice,
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    )
)