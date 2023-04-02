package v.sivasubramaniam.calendar.feature_reminder.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import v.sivasubramaniam.calendar.core.presentation.ui.theme.HavelockBlue

@Composable
fun AccountItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(color = HavelockBlue)
        )
        Column(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            Text(
                text = "Reminders",
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = text,
                style = MaterialTheme.typography.caption
            )
        }
    }
}