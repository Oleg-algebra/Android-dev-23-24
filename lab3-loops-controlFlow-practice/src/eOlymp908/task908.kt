package eOlymp908

fun main(){
    val n = readln()
    val list = readln().split("\\s+".toRegex())
            .map { it.toInt() }
            .filter { (it % 6 == 0) && (it >0)}
    println("${list.size} ${list.sum()}")
}