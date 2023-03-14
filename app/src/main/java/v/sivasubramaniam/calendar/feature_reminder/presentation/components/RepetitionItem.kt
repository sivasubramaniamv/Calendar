package v.sivasubramaniam.calendar.feature_reminder.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RepetitionItem(
    text: String,
    isChosen: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = if (isChosen) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.weight(1f))
        if (isChosen) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Chosen Repetition",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}