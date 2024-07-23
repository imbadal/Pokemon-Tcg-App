package com.android.pokemontcg.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object AppUtils {
    fun formatTimestamp(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}