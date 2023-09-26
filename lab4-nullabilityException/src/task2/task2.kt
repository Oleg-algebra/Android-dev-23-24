package task2

import kotlin.random.Random

/*
2. Дано послідовність (список, масив) нулабельних рядків.
Підрахуйте загальну кількість символів, що містять усі рядки.
 */
fun main() {
    val list = listOf(
            "el1",
            null,
            "el2",
            "el4",
            null,
            "lkrl",
            null,
            "kfhh",
    )
    println("Total amount of characters: ${list.sumOf { it?.length ?: 0 }}")
}

