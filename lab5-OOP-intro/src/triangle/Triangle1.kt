package triangle


import kotlin.math.sqrt

class Triangle1 {// третя сторона трикутника

    var a: Float = 1f
        set(value) {
            if (!isExist) return
            field = value
        }

    var b: Float = 1f
        set(value) {
            if (!isExist) return
            field = value
        }

    var c: Float = 1f
        set(value) {
            if (!isExist) return
            field = value
        }

    private val isExist: Boolean
        get() = a + b > c && a + c > b && b + c > a

    // перша сторона трикутника// друга сторона трикутника
    constructor(a: Float, b: Float, c: Float) {
        this.a = a
        this.b = b
        this.c = c
        println("Викликається первинний конструктор")
        if (!(a + b > c && a + c > b && b + c > a))
            throw IllegalArgumentException("Не виконується нерівність трикутника. Triangle(a=${this.a}, b=${this.b}, c=${this.c})")
    }

    constructor(
        a: Int,// перша сторона трикутника
        b: Int,// друга сторона трикутника
        c: Int,// третя сторона трикутника)
    ) : this(a.toFloat(), b.toFloat(), c.toFloat())

    constructor(a: Float) : this(a, a, a)  // Рівносторонній трикутник
    constructor(a: Int) : this(a, a, a)   // Рівносторонній трикутник
    constructor(a: Float, b: Float) :
            this(a, b, sqrt(a * a + b * b))   // Прямокутний трикутник

    override fun toString(): String {
        return "Triangle(a=$a, b=$b, c=$c)"
    }

    val perimeter: Float
        get() = a + b + c


}

//fun main() {
//    val t = Triangle1(3, 3, 4)
//    println(t)
////    println(t.perimeter)
////    t.a = 4f
////    println(t.a)
////    println(t.perimeter)
////    t.a = 12f
//    println(t)
//
//}