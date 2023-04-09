package v.sivasubramaniam.calendar.feature_home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EventListItem(
    day: String,
    date: String,
    events: List<String>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        events.forEachIndexed { index, event ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 4.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (index == 0) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = day,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = date,
                            fontSize = MaterialTheme.typography.h6.fontSize
                        )
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                } else {
                    Spacer(modifier = Modifier.width(44.dp))
                }
                EventCard(event = event)
            }
        }
    }
}