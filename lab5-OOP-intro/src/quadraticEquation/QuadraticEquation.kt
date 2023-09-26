package quadraticEquation

import kotlin.math.sqrt
import kotlin.random.Random


/*
2. Опишіть клас Квадратне рівняння, що визначається трьома коефіцієнтами.
Для цього класу виконайте таке:
•    Опишіть первинний конструктор з параметрами, які використовуються для ініціалізації об’єкту.
•    В блоці init здійсніть перевірку, чи задані параметри визначають квадратне рівняння
(ініціюйте виключення, якщо ні)
•    Перетворіть первинний конструктор у конструктор з ініціалізацією полів.
•    Створіть вторинний конструктор з вхідними параметрами типу Int.
•    Створіть вторинний конструктор, так, щоб коефіцієнт при другому степені був одиниця.
•    Опишіть метод toString(), що виводить інформацію про квадратне рівняння у вигляді легкому
для сприйняття.
•    Опишіть властивість, що визначає дискримінант цього рівняння.
•    Створіть метод, що повертає розв’язки цього рівняння.
•    Модифікуйте поля класу, так щоб їх можна було змінювати.
Для коефіцієнту при старшому степені перевірте, чи він не нуль.
Використовуючи цей клас розв’яжіть таку задачу. Випадковим чином генерується 100 квадратних рівнянь.
Виведіть на екран ті з них, що мають рівно два розв’язки.
 */

class QuadraticEquation(aa: Double, bb: Double, cc: Double) {

    var a = aa
        set(value) {
            val oldValue = field
            field = value
            if (isQuadratic) return
            field = oldValue
        }
    var b = bb
    var c = cc

    private val errorMessage = "Equation: $a*x^2 + $b*x + $c = 0 is not quadratic"

    init {
        if (!isQuadratic) throw IllegalArgumentException(errorMessage)
    }

    private val isQuadratic : Boolean
        get() = (a!=0.0)

    constructor(a: Int, b: Int, c: Int): this(a.toDouble(),b.toDouble(),c.toDouble())

    constructor(b: Int, c: Int): this(1, b,c)
    constructor(b: Double,c:Double): this(1.0, b,c)

    override fun toString(): String {
        return "Equation: $a*x^2 + $b*x + $c = 0"
    }
    val discriminant: Double
        get() = b*b - 4 * a * c
    val solution: List<Double>
        get() {
            val res = ArrayList<Double>()
            if(discriminant >= 0){
                val b2a = -b / (2*a)
                val D2a = sqrt(discriminant) / (2*a)
                res.add(b2a + D2a)
                if(D2a > 0) {
                    res.add(b2a - D2a)
                }
            }
            return  res
        }

}

fun getRandomEquation(): QuadraticEquation {
    val type = Random.nextInt(1, 5)
    val randD = { Random.nextDouble() * 5  - 10}
    val randI = { Random.nextInt(-5 ,6) }
    return try {
        when (type) {
            1 -> QuadraticEquation(randD(), randD(), randD())
            2 -> QuadraticEquation(randD(), randD())
            3 -> QuadraticEquation(randI(), randI(), randI())
            else -> QuadraticEquation(randI(), randI())
        }
    } catch (e: IllegalArgumentException) {
        if (type in listOf(1, 2)) {
            QuadraticEquation(randD(), randD())
        } else {
            QuadraticEquation(randI(), randI())
        }
    }

}

fun main() {
    val n = 100
    val list = Array(n){ _ -> getRandomEquation() }

    val equations2 = list.filter { it.solution.size == 2 }
    for (eq in equations2){
        println("$eq \n roots: ${eq.solution}")
    }


}