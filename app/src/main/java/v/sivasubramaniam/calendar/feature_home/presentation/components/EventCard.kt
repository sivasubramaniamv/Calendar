package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import v.sivasubramaniam.calendar.core.presentation.ui.theme.MineShaft
import v.sivasubramaniam.calendar.core.presentation.ui.theme.OceanGreen

@Composable
fun EventCard(  // TODO: change param event: EventResponse
    event: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = OceanGreen,
    ) {
        Text(
            text = event,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
            color = MineShaft,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}