class Parallelogram(
    private val a: Double,
    private val b: Double,
    private val h: Double,
) : Shape(){

    init {
        if (!isExist) throw IllegalArgumentException()
    }
    private val isExist: Boolean
        get() = a>0 && b>0 && h>0
    override fun dimension(): Int = 2

    override fun perimeter(): Double? = 2*(a+b)

    override fun square(): Double? = a * h
    override fun volume(): Double? = square()
    override fun toString(): String {
        return "Parallelogram(a=$a, b=$b, h=$h)"
    }

}