package org.insbaixcamp.appfitnessivanortega.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnessivanortega.model.WeightTracking
import org.insbaixcamp.appfitnessivanortega.ui.theme.AppFitnessIvanOrtegaTheme
import java.util.Date

@Composable
fun WeightTrackingItem(weightTracking: WeightTracking) {
    Row(Modifier.fillMaxWidth().padding(8.dp)) {
        Text(
            text = formatDate(weightTracking.date),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "${weightTracking.pes} Kg",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun WeightTrackingItemPreview() {
    var weightTracking = WeightTracking(System.currentTimeMillis(), 75.0)

    AppFitnessIvanOrtegaTheme {
        WeightTrackingItem(weightTracking)
    }

}