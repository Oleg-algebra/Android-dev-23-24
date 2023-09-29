import kotlin.math.PI

open class Circle(private val  radius: Double) : Shape(){
    init {
        if (!isExist) throw IllegalArgumentException()
    }
    private val isExist: Boolean
        get() = radius>0
    override fun dimension(): Int = 2

    override fun perimeter(): Double? = 2 * PI * radius

    override fun square(): Double? = PI * radius * radius
    override fun volume(): Double? = square()
    override fun toString(): String {
        return "Circle(radius=$radius)"
    }

}