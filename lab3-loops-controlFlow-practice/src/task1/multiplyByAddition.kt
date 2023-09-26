package task1

fun multiply(a: Int, b:Int): Int{
    var res = 0
    for(i in 0 ..<b) res+=a
    return res
}

fun main(){
    val a = 7
    val b = 9
    println(multiply(a,b))

    var res = 0
    repeat(a){res+=b}
    println(res)

}