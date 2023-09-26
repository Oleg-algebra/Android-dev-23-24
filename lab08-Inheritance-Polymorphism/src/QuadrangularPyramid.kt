import kotlin.math.sqrt

class QuadrangularPyramid(
    private val base1: Double,
    private val base2: Double,
    private val h: Double,
) : Rectangle(base1,base2){
    override fun dimension(): Int = 3

    override fun perimeter(): Double? = null

    override fun square(): Double? = null

    override fun volume(): Double? = squareBase()?.times(1/3)?.times(h)

    override fun squareSurface(): Double? {
        val hl1 = sqrt(h*h + base1*base1/4)
        val hl2 = sqrt(h*h + base2*base2/4)
        return squareBase()?.plus(base1*hl1 + base2*hl2 )
    }

    override fun squareBase(): Double? = super.square()

    override fun height(): Double? = h
    override fun toString(): String {
        return "QuadrangularPyramid(base1=$base1, base2=$base2, h=$h)"
    }

}