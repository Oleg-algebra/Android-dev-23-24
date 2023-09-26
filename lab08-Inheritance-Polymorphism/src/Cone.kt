import kotlin.math.PI
import kotlin.math.sqrt

class Cone(
    private val radius: Double,
    private val h: Double,
) : Circle(radius){
    override fun dimension(): Int = 3

    override fun perimeter(): Double? = null

    override fun square(): Double? = null

    override fun volume(): Double? = super.square()?.times(1/3)?.times(h)

    override fun squareSurface(): Double? {
        val hl = sqrt(radius*radius + h*h)
        return squareBase()?.plus(PI*radius*hl)
    }

    override fun squareBase(): Double? = super.squareBase()

    override fun height(): Double? = h
    override fun toString(): String {
        return "Cone(radius=$radius, h=$h)"
    }

}