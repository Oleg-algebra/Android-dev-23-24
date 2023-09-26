import kotlin.math.sqrt

class TriangularPyramid (
    private val base1: Double,
    private val h: Double,
): Triangle(base1,base1,base1){
    override fun squareSurface(): Double? {
        val d = base1*sqrt(3.0)/6
        val hl = sqrt(d*d + h*h)
        val sl = 0.5*hl*base1*3
        return squareBase()?.plus(sl)
    }

    override fun squareBase(): Double? {
        return super.square()
    }

    override fun height(): Double? {
        return h
    }

    override fun dimension(): Int {
        return 3
    }

    override fun perimeter(): Double? {
        return null
    }

    override fun square(): Double? {
        return null
    }

    override fun volume(): Double? {
        return squareBase()?.times(1/3)?.times(h)
    }

    override fun toString(): String {
        return "TriangularPyramid(base1=$base1, h=$h)"
    }

}