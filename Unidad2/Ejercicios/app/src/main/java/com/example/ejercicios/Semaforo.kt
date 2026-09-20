package com.example.ejercicios

fun main(){

    val signal = "Yellow"

    if (signal == "Red"){
        println("Stop")
    } else if ( signal == "Yellow"){
        println("Slow")
    } else if (signal == "Green"){
        println("Go")
    } else {
        println("Invalid color")
    }

}