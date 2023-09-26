package triangle


import kotlin.math.abs
import kotlin.math.sqrt
import kotlin.random.Random

/*
Перша задача, це задача з лекції. Виконувати не обов'язково.
1. Опишіть клас Трикутник, що визначається трьома сторонами. Для цього класу виконайте таке:
•    Опишіть первинний конструктор з параметрами, які використовуються для ініціалізації об’єкту.
•    В блоці init здійсніть перевірку, чи такий трикутник можна створити
(ініціюйте виключення, якщо не можна)
•    Перетворіть первинний конструктор у конструктор з ініціалізацією полів.
•    Створіть вторинний конструктор, так, щоб параметри задавалися типу Int
•    Створіть два вторинних конструктори для створення рівностороннього та прямокутного трикутників.
•    Опишіть метод toString(), що виводить інформацію про трикутник у вигляді легкому для сприйняття.
•    Модифікуйте поля класу, так щоб можна було змінювати сторони трикутника.
Врахуйте, що зміна сторін трикутника повинна враховувати перевірку умови існування цього трикутника.
•    Створіть властивість для підрахунку периметра та площі трикутника.
Використовуючи цей клас розв’яжіть таку задачу. Випадковим чином генерується 100 трикутників.
Тип трикутника (довільний, рівносторонній, прямокутний) обирається також довільним чином.
Виведіть на екран той (ті) з них, що мають найбільшу площу.
 */
class Triangle(aa: Double, bb: Double, cc:Double){

    var a: Double = aa
        set(value) {
            val oldValue = field
            field = value
            if (isExist) return
            field = oldValue
        }
    var b: Double = bb
        set(value) {
            val oldValue = field
            field = value
            if (isExist) return
            field = oldValue
        }
    var c: Double = cc
        set(value) {
            val oldValue = field
            field = value
            if (isExist) return
            field = oldValue
        }
    init {
        if (!isExist){
            throw IllegalArgumentException(errorMessage)
        }
    }

    private val errorMessage: String
        get() = "Triangle with sides $a,$b,$c does not exist. The triangle inequality does not hold"

    private val isExist: Boolean
        get() {
            return a + b > c && a + c > b && b + c > a
        }
    constructor(a: Int, b:Int, c:Int): this(a.toDouble(),b.toDouble(),c.toDouble())
    constructor(a: Double): this(a,a,a)
    constructor(a: Int): this(a,a,a)
    constructor(a: Double, b: Double): this(a,b, sqrt(a*a + b*b))
    constructor(a: Int, b: Int): this(a.toDouble(),b.toDouble())

    override fun toString() = "Triangle: a= $a, b= $b, c= $c"

    val perimeter: Double
        get() = a + b + c

    val square: Double
        get(){
            val p2 = perimeter / 2
            return sqrt(p2 * (p2 - a) * (p2 - b) * (p2 - c))
        }


}


fun main() {
    val n = 100

    val randD = {Random.nextDouble()*10 + 1}
    val randI = {Random.nextInt(1,11)}
    // lambda function to generate random triangle to fill array
    val triangleGenerator = {i: Int ->
        val type = Random.nextInt(1,7)
        try {
            when(type){
                1 -> Triangle(randD(),randD(),randD())
                2 -> Triangle(randD())
                3 -> Triangle(randD(),randD())
                4 -> Triangle(randI(),randI(),randI())
                5 -> Triangle(randI())
                else -> Triangle(randI(),randI())
            }
        }catch (e: IllegalArgumentException){
            if (type in 1..3){
                Triangle(randD())
            }else{
                Triangle(randI())
            }
        }

    }
    val list = Array(n,triangleGenerator)

    list.sortBy { it.square }
    list.reverse()
    val maxSquare = list.first().square
    val eps = 1e-2
    for (t in list){
        if (abs(t.square - maxSquare) < eps) println(t)
    }
}