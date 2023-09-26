import java.util.Collections.replaceAll
import kotlin.random.Random

/*
2. Опишіть функцію, що створює масив заданого розміру (elem_number)
та заповнений випадковими числами, що змінюються в межах від 0 до max_value.
•    Якщо один з заданих параметрів функції elem_number або max_value,
 менший або дорівнює нулю, то функція має повертати значення null.
•    Створіть екземпляр цього масиву скориставшись описаною функцією.
•    Використовуючи scope-функції, для заданого масиву збільште вдвічі
кожний непарний елемент цього масиву та зменште вдвічі кожен парний елемент цього масиву.
•    Виведіть модифікований на попередньому кроці масив на екран.
•    Знайдіть максимальний елемент отриманого масиву (як результат застосування однієї зі scope-функцій).
•    Виведіть результат обчислень на попередньому кроці у вигляді повідомлення
Максимальне значення масиву: 100500

Зауваження. Задачу потрібно розв’язати не використовуючи змінних оголошених у методі
main – всі обчислення та їхній результат мають бути ланцюжком викликів scope-функцій.
 */

fun getArray(elemNumber: Int,maxValue: Int): MutableList<Int>?{
    if(elemNumber <= 0 || maxValue <= 0) return null
    return MutableList(elemNumber){Random.nextInt(maxValue)}
}

fun doOperations(elemNumber: Int,maxValue: Int){
    println("elemNumber: $elemNumber, maxValue: $maxValue")
    getArray(elemNumber, maxValue)
        ?.also {  println("Array before transformation:\n $it")}
        ?.apply{
        replaceAll { if (it % 2 ==0) it/2 else it*2 }

        }
        ?.let{
            println("Array after transformation:\n $it")
            println("Максимальне значення: ${it.max()}")
        }
}

fun main() {
    doOperations(10,15)
    println("===================================")
    doOperations(0,9)
    println("===================================")
    doOperations(9,-1)
    println("===================================")
    doOperations(30,1000)
}