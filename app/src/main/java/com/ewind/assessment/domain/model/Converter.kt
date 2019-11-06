package com.ewind.assessment.domain.model

import com.ewind.assessment.data.remote.model.Location
import com.ewind.assessment.data.remote.model.Shift

fun Shift.toViewModel(): DShift = DShift(
    currency,
    duration,
    earningsPerHour,
    endDatetime,
    endTime,
    id,
    isAutoAcceptedWhenAppliedFor,
    startDate,
    startDatetime,
    startTime,
    tempersNeeded
)

fun Location.toViewModel(): DLocation = DLocation(
    lat, lng
)