package com.example.ejercicios_unidad_1

fun main() {
    val cities = arrayOf("Ankara", "Tokyo", "Cape Town", "Guatemala City")
    val lowTemperatures = arrayOf(27, 32, 59, 50)
    val highTemperatures = arrayOf(31, 36, 64, 55)
    val chanceRains = arrayOf(82, 10, 2, 7)

    for (i in 0 until 4) {
        print(printName(cities[i]))
        print(printTemperature(lowTemperatures[i], highTemperatures[i]))
        print(printChanceRain(chanceRains[i]))
        print("\n")
    }
}

fun printName(name: String): String {
    return "City: $name\n"
}

fun printTemperature(tempLow: Int, tempHigh: Int): String {
    return "Low temperature: $tempLow, High temperature: $tempHigh\n"
}

fun printChanceRain(percent: Int): String {
    return "Chance of rain: $percent%\n"
}