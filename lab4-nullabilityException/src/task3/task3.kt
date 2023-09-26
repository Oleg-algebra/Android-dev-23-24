package task3

/*
3. Дано послідовність, нулабельних рядків частину з яких можна конвертувати у числа.
 Знайдіть:
•    Суму дійсних чисел, що містяться у послідовності (0, якщо послідовність
        не містить жодного дійсного числа).
•    Найбільше серед цілих чисел (виведіть null, якщо послідовність
        не містить жодного дійсного числа).
 */

fun main(){
    val list1 = listOf(
            "2.454",
            null,
            "938.3049",
            "938",
            null,
            "0.0934",
            "9403",
            null
    )
    val list2: List<String?> = listOf(
            null,
            null,
            null,
            null,
    )

    println("list1: $list1 \n sum of elements: ${elementsSum(list1)}" +
            "\n maxElement: ${findMax(list1)}")
    println("list2: $list2 \n sum of elements: ${elementsSum(list2)}" +
            "\n maxElement: ${findMax(list2)}")
}

fun elementsSum(list: List<String?>) = list.sumOf { it?.toDouble() ?: 0.0 }
fun findMax(list: List<String?>): Double? {
    val list1 = list.mapNotNull { it?.toDouble() }
    return if (list1.isNotEmpty()){
            list1.max()
        } else{
        null
    }
}