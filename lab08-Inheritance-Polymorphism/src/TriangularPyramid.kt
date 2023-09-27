import kotlin.math.sqrt

class TriangularPyramid (
    private val base1: Double,
    private val h: Double,
): Triangle(base1,base1,base1){
    init {
        if(!isExist) throw IllegalArgumentException()
    }
    private val isExist: Boolean
        get() = h>0
    override fun squareSurface(): Double? {
        val d = base1*sqrt(3.0)/6.0
        val hl = sqrt(d*d + h*h)
        val sl = 0.5*hl*base1*3
        return squareBase()?.plus(sl)
    }

    override fun squareBase(): Double? {
        val p2 = super.perimeter()?.div(2)
        return p2?.let { sqrt(it*(it-base1)*(it-base1)*(it-base1))}
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
        val s = squareBase()
        return squareBase()?.times(1.0/3.0)?.times(h)
    }

    override fun toString(): String {
        return "TriangularPyramid(base1=$base1, h=$h)"
    }

}