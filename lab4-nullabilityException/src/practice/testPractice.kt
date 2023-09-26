package practice

fun main() {
    println(test(6))
    val k = 5
    var n = test(k)?:0
    println(n)
}

fun test(arg: Int) = if (arg>5) arg*2 else null