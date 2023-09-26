
fun main(){
    readNumber(5)
//    readNumbersSequence()

}

// Task 2. На вхід подається дійсне число. Вивести його з n знаками після коми.
// 8092384.2342
// .344334
// 343434
/**
  :n кількість цифр після коми
 */
fun readNumber(n: Int){

    val num = readln()
        .replace(',','.').toDouble()
    println("%.${n}f".format(num)
        .replace(',','.'))
}

// Task 3. На вхід подається набір чисел розділених одним або декількома пропусками.
// Потрібно створити масив (список) цих чисел
// val x = readln()
// 12     234      12    443.4
//  298374    2983472,2394029   234,2342  2342.2342      23424 2344     .3234424

fun readNumbersSequence(){
    val numbers = readln()
        .split("\\s+".toRegex())
        .map({ num: String -> num.replace(',', '.')
                        .toDouble()
        })
    println(numbers)
}