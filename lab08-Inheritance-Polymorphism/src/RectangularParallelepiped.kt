class RectangularParallelepiped(
    private val side1: Double,
    private val side2: Double,
    private val h: Double,
) :Rectangle(side1,side2){
    override fun dimension(): Int = 3

    override fun perimeter(): Double? = null

    override fun square(): Double? = null

    override fun volume(): Double? = super.square()?.times(h)


    override fun squareSurface(): Double? = super.perimeter()?.times(h)

    override fun squareBase(): Double? = super.square()

    override fun height(): Double? = h
    override fun toString(): String {
        return "RectangularParallelepiped(side1=$side1, side2=$side2, h=$h)"
    }
}