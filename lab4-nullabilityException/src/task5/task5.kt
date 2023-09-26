package task5

/*
5. До програми з клавіатури надходить послідовність цифр.
Послідовність задається доти, поки користувач не введе слово «досить».
Слід зауважити, що користувач не є дисциплінованим і може заміть цифр вводити будь-що.
Якщо користувач вводить з клавіатури число більше за 9,
то програма ініціює виключення IllegalArgumentException.
Якщо користувач вводить число менше за 0, то програма
ініціює виключення ArithmeticException.
Якщо користувач вводить дійсне значення з діапазону від 0 до 9,
то програма ініціює виключення IndexOutOfBoundsException.
Підрахувати кількість виключень кожного типу, що виникають у програмі.
 */

fun main() {
    var counter1 = 0    // IllegalArgumentException counter
    var counter2 = 0    // ArithmeticException counter
    var counter3 = 0    // IndexOutOfBoundsException counter


    while (true){
        try {
            val n: String  = readln().replace(',','.')

            if (n == "досить") break
            when{
                n.toDouble()<0 -> throw  ArithmeticException()
                n.toDouble()>9 -> throw IllegalArgumentException()
                else -> throw IndexOutOfBoundsException()
            }
        }catch (e: NumberFormatException){
            continue
        }catch (e: IllegalArgumentException){
//            println("IllegalArgumentException")
            counter1++
        }catch (e: ArithmeticException){
//            println("ArithmeticException")
            counter2++
        }catch (e: IndexOutOfBoundsException){
//            println("IndexOutOfBoundsException")
            counter3++
        }
    }
    println("ArithmeticException counts: $counter2")
    println("IllegalArgumentException counts: $counter1")
    println("IndexOutOfBoundsException counts: $counter3")
}