package eOlymp904

fun main(){
    val n = readln().toInt()

    println( readln().split("\\s+".toRegex())
            .map { it.toInt() }
            .map{ if (it >= 0) it + 2 else it}
            .fold(""){res,cur -> "$res$cur "}
            .trim() )
}