package com.anb.moviedemo.presentation.base

import java.text.SimpleDateFormat
import java.util.*

fun getFormattedTime(timestampInMs: Long, format: String = "d MMMM yyyy"): String {
    if (timestampInMs <= 0) {
        return ""
    }
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone("UTC")
    return formatter.format(timestampInMs)
}
