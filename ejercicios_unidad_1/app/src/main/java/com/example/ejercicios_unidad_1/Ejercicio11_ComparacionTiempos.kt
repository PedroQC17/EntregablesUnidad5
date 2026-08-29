package com.example.ejercicios_unidad_1

fun comparationTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}

fun main() {
    val time1 = 200
    val time2 = 300
    val time3 = 300

    print("time1 = $time1 < time2 = $time2 : resultado => ${comparationTime(time1, time2)}")
}