package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import v.sivasubramaniam.calendar.core.presentation.ui.theme.BlueMarguerite
import v.sivasubramaniam.calendar.core.presentation.ui.theme.SteelBlue

@Composable
fun EventDisplayChoice(
    email: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageOption(text = email)
        CheckboxOption(
            checked = true,
            text = "Events",
            color = SteelBlue,
            onClick = { }
        )
        CheckboxOption(
            checked = true,
            text = "Tasks",
            color = BlueMarguerite,
            onClick = { }
        )
        CheckboxOption(
            checked = true,
            text = "Reminders",
            color = BlueMarguerite,
            onClick = { }
        )
    }
}