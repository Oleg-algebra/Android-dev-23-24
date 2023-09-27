import kotlin.math.sqrt

class TriangularPrism(
    private val side1: Double,
    private val side2: Double,
    private val side3: Double,
    private val h: Double,
): Triangle(side1,side2,side3){
    init {
        if(!isExist) throw IllegalArgumentException()
    }
    private val isExist: Boolean
        get() = h>0
    override fun squareSurface(): Double? {
        return super.perimeter()?.times(h)
    }

    override fun squareBase(): Double? {
        val p2 = super.perimeter()?.div(2)
        return p2?.let { sqrt(it*(it-side1)*(it-side2)*(it-side3)) }

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
        return squareBase()?.times(h)
    }

    override fun toString(): String {
        return "TriangularPrism(side1=$side1, side2=$side2, side3=$side3, h=$h)"
    }
}