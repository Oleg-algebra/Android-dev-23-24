import kotlin.math.PI

class Ball(
    private val radius: Double
) : Shape(){
    override fun dimension(): Int = 3
    override fun squareSurface():Double? = 4*PI*radius*radius
    override fun volume():Double? = (4 / 3) * PI * radius * radius * radius
    override fun height():Double? = radius
    override fun toString(): String {
        return "Ball(radius=$radius)"
    }

}