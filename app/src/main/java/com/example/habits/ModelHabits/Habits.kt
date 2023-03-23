package com.example.habits.ModelHabits

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Habits(
    val name: String,
    val descriptor: String,
    val priority: String,
    val type: String,
    val count: String,
    val period: String
) : Parcelable {
    override fun toString(): String {
        return "$name\nописание: $descriptor\n" +
                "приоритет: $priority\nтип: $type\nколичество: $count\n" +
                "период: $period"
    }
}


