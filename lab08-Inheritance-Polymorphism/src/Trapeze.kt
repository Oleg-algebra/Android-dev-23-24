import kotlin.math.abs
import kotlin.math.sqrt

class Trapeze(
    private val base1: Double,
    private val base2: Double,
    private val lateral1: Double,
    private val lateral2: Double,
) : Shape(){
    override fun dimension(): Int = 2


    override fun perimeter(): Double? = base1 + base2 + lateral1 + lateral2

    override fun square(): Double? {
        val p2 = perimeter()?.times(2)
        val r = (base1 + base2)/(abs(base1 - base2))
        return p2?.let {  r * sqrt((it -base1)*(it - base2) * (it - base1 - lateral1)*
                (it - base1 - lateral2))}
    }

    override fun volume(): Double? = square()
    override fun toString(): String {
        return "Trapeze(base1=$base1, base2=$base2, lateral1=$lateral1, lateral2=$lateral2)"
    }

}