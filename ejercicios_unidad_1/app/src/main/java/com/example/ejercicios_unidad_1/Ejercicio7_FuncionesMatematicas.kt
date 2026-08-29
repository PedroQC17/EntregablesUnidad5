package com.example.ejercicios_unidad_1

fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)
    val result1 = subtract(thirdNumber, secondNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$thirdNumber - $secondNumber = $result1")
}

fun add(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun subtract(num1: Int, num2: Int): Int {
    return num1 - num2
}