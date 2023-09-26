package eOlymp910

import java.util.*

fun main(){
    val n = readln().toInt()
    val list = readln().split("\\s+".toRegex())
            .map { it.toDouble() }
            .filter { it > 0 }
    println(if(list.isEmpty()){
        "Not Found"
    }else{
        String.format(Locale.US,"%.2f",(list.sum()/list.size))
    })
}