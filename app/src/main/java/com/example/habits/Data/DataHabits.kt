package com.example.habits.Data

import com.example.habits.ModelHabits.Habits


class DataHabits {
    private var habitsList: MutableList<Habits> = mutableListOf()

    fun getList() : MutableList<Habits> {
        return habitsList
    }

    fun getCount(): Int {
        return habitsList.size
    }

    fun getItem(position: Int): Any {
        return habitsList[position]
    }

    fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun addHabits(habits: Habits) {
        habitsList.add(habits)

    }

    fun removeHabitsAt(position: Int) {
        habitsList.removeAt(position)

    }
}