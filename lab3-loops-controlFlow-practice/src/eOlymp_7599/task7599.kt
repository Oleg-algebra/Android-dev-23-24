package eOlymp_7599

fun main(){
    val n = readln().toInt()
    val list = (10..99).toList()

    println(when(n){
        1 -> { list.count { (it / 10) > (it % 10) } }
        2 -> {list.count { (it / 10) < (it % 10) } }
        3 -> {list.count { (it / 10)%2 == (it % 10)%2 }}
        4 -> {list.filter { (it / 10) == (it % 10) }.sum()}
        5 -> {list.filter { ((it / 10)%2==0) && ((it % 10)%2==0) }.sum()}
        6 -> {list.filter { ((it / 10)%2==1) && ((it % 10)%2==1) }.sum()}
        else -> {}
    })
}