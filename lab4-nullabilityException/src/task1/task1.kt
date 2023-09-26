package task1
/*
1. Опишіть функцію, що за заданим номером повертає назву відповідного місяця.
 Якщо вхідне значення задається неправильно, функція має повертати null.
 Крім цього опишіть функцію, що за назвою місяця повертає назву сезону,
 до якого належить зазначений місяць.
 Використовуючи ці функції виведіть повідомлення на кшталт:
січень -> зима
 */
fun main(){
    println("Enter month number: ")
    val n = readln().toInt()
    val month = getMonth(n)
    val season = getSeason(month)
    println("$month->$season")
}

fun getMonth(n: Int): String?{
    return when(n){
        1 ->"January"
        2 ->"February"
        3 -> "March"
        4 -> "April"
        5 -> "May"
        6 -> "June"
        7 -> "July"
        8 -> "August"
        9 -> "September"
        10 -> "October"
        11 -> "November"
        12 -> "December"
        else -> null
    }
}
fun getSeason(month: String?): String?{
    return when(month){
        in listOf("December","January","February") -> "winter"
        in listOf("April","May","March") -> "spring"
        in listOf("June","July","August") -> "summer"
        in listOf("September","October","November") -> "autumn"
        else -> null
    }
}