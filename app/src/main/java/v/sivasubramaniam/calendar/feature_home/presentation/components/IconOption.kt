package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import v.sivasubramaniam.calendar.core.presentation.ui.theme.Pumice

@Composable
fun IconOption(
    @DrawableRes drawableRes: Int,
    option: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = drawableRes),
            contentDescription = option,
            tint = Pumice
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = option,
            fontSize = MaterialTheme.typography.body2.fontSize,
            fontWeight = FontWeight.SemiBold
        )
    }
}