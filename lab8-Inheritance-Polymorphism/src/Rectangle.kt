open class Rectangle (
    private val a: Double,
    private val b: Double,
): Shape() {
    init {
        if(!isExist) throw IllegalArgumentException()
    }
    private val isExist: Boolean
        get() = a>0 && b>0
    override fun dimension(): Int = 2

    override fun perimeter(): Double? = (a + b) *2

    override fun square(): Double? = a*b
    override fun volume(): Double? = square()
    override fun toString(): String {
        return "Rectangle(a=$a, b=$b)"
    }


}