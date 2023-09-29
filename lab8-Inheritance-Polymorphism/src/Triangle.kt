import kotlin.math.sqrt

open class Triangle(
    private val a: Double,
    private val b: Double,
    private val c: Double,
) : Shape() {

    init {
        if(!isExist){
            throw IllegalArgumentException("Triangle(a=$a, b=$b, c=$c) is not exist!")
        }
    }
    private val isExist: Boolean
        get() {
            return a+b>c && a+c>b && b+c>a && a>0 && b>0 && c>0
        }
    override fun dimension(): Int = 2

    override fun perimeter():Double? = a + b + c

    override fun square(): Double?{
        val p2 = perimeter()?.div(2)
        return p2?.let { sqrt(it*(it-a)*(it-b)*(it-c)) }
    }

    override fun volume() = square()
    override fun toString(): String {
        return "Triangle(a=$a, b=$b, c=$c)"
    }


}