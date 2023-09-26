
abstract class Shape {
    abstract open fun dimension(): Int
    open fun perimeter(): Double? = null
    open fun square(): Double? = null
    open fun squareSurface(): Double? = null
    open fun squareBase(): Double? = null
    open fun height(): Double? = null
    open fun volume(): Double? = null

}
