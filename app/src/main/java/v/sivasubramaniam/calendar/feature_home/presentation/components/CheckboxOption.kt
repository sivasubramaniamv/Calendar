package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxOption(
    checked: Boolean,
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox( // TODO: reduce checkbox size - Modifier.size() only affects padding around checkbox, not the checkbox itself
            checked = checked,
            onCheckedChange = { onClick() },
            colors = CheckboxDefaults.colors(
                checkedColor = color,
                uncheckedColor = color,
                checkmarkColor = MaterialTheme.colors.onPrimary
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = MaterialTheme.typography.body2.fontSize,
            fontWeight = FontWeight.SemiBold
        )
    }
}