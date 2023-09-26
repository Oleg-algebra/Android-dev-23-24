package eOlymp3935

fun main(){
    val n = readln().toInt()
    val list = mutableListOf<String>()
    repeat(n){list.add(readln())}
    val reversed = list.reversed()
    println( reversed.fold(""){ result, current -> "$result$current "}.trim())
}