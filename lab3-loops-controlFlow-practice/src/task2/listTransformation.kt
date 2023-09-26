package task2

import kotlin.random.Random

fun main(){
//    val list = mutableListOf<Int>()
//    val n = 100
//    for (i in 1..n)
//        list.add(Random.nextInt(-100,101))
//    val list1 = List(100){Random.nextInt(-100,100)}
    val array = Array(100){Random.nextInt(-100,100)}
    val res = array.filter { it >0 }
            .filter { it % 5 == 0 }
            .map { it*it }
            .sortedDescending()
    println(res)
    val max = res.first()
    val min = res.last()
    println("max: $max")
    println("min: $min")

    val res1 = res.map { it - 100 }
            .map { it.toString() }
            .fold(""){res1,currentItem
                -> "$res1$currentItem "}
                    .trim()
    println("|$res1|")
}