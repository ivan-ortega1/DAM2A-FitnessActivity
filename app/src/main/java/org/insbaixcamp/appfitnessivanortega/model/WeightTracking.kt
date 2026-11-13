package org.insbaixcamp.appfitnessivanortega.model

import java.util.Calendar

data class WeightTracking(
    // data is date in millis
    val date: Long,
    var pes: Double
)