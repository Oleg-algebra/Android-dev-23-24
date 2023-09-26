package eOlymp8236

fun main(){
    val n = readln().toInt()
    val list = readln().split("\\s+".toRegex())
            .map { it.toInt() }
    val even = list.filter { it % 2 == 0 }.sortedDescending()
    val odd = list.filter { it % 2 == 1 || it % 2 == -1 }.sorted().toMutableList()
    odd.addAll(even)
    println(
            odd.fold(""){res,curr->"$res$curr "}.trim()
    )
}