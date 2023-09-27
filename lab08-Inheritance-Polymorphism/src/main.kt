import java.io.File
import kotlin.random.Random

/**
 * Return Shape by given string description
 * If parameters incorrect(get IllegalArgumentException) then return null.
 */
fun getShape(description: String): Shape?{
    val params = description.trim().split("\\s++".toRegex()).toMutableList()

    val type = params.removeAt(0)
    val pDs = params.map { it.toDouble() }
    try {
        return when(type){
            "Circle" -> Circle(pDs[0])
            "Triangle" -> Triangle(pDs[0],pDs[1],pDs[2])
            "Rectangle" -> Rectangle(pDs[0],pDs[1])
            "Trapeze" -> Trapeze(pDs[0],pDs[1],pDs[2],pDs[3])
            "Parallelogram" -> Parallelogram(pDs[0],pDs[1],pDs[2])
            "Ball" -> Ball(pDs[0])
            "TriangularPyramid" -> TriangularPyramid(pDs[0],pDs[1])
            "QuadrangularPyramid" -> QuadrangularPyramid(pDs[0],pDs[1],pDs[2])
            "RectangularParallelepiped" -> RectangularParallelepiped(pDs[0],pDs[1],pDs[2])
            "Cone" -> Cone(pDs[0],pDs[1])
            else -> TriangularPrism(pDs[0],pDs[1],pDs[2],pDs[3])
        }
    }catch (e: IllegalArgumentException){
//        println("Exception: $type")
        return null
    }

}

/**
 * Function test formulas correctness for some parameters
 */
fun test1(){
    val figuresList = listOf(
        Circle(1.0),
        Triangle(1.0,1.0,1.0),
        Rectangle(2.0,3.0),
        Trapeze(5.0,2.0,3.0,3.0),
        Parallelogram(5.0,6.0,4.0),
        Ball(1.0),
        TriangularPyramid(1.0,3.0),
        QuadrangularPyramid(1.0,2.0,3.0),
        RectangularParallelepiped(1.0,2.0,3.0),
        Cone(1.0,1.0),
        TriangularPrism(1.0,1.0,1.0,1.0),
    )

    figuresList.forEach{figure->
        println("====================================")
        println(figure)
        with(figure){
            println("perimeter: ${perimeter()}")
            println("square: ${square()}")
            println("dim: ${dimension()}")
            println("squareBase: ${squareBase()}")
            println("squareSurface: ${squareSurface()}")
            println("volume: ${volume()}")
            println("height: ${height()}")
        }

    }
}

/**
 * Function to test correctness of parameters value checking
 */
fun test2(){
    val n = (1e6).toInt()
    var counter = 0
    repeat(n) {
        val type = it%11
        try {
            when (type) {
                1 -> Circle(Random.nextDouble(-5.0, 0.0))
                2 -> Triangle(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                3 -> Rectangle(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                4 -> Trapeze(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                5 -> Parallelogram(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                6 -> Ball(Random.nextDouble(-5.0, 0.0))
                7 -> TriangularPyramid(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                8 -> QuadrangularPyramid(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                9 -> RectangularParallelepiped(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                10 -> Cone(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )

                else -> TriangularPrism(
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0),
                    Random.nextDouble(-5.0, 0.0)
                )
            }
        }catch (e: IllegalArgumentException){
            counter++
        }
    }
    println("counter == $n: ${counter==n}")
}

/**
 * implements solution procedure
 */
fun solution(){
    val files = File("src/resourses").listFiles()
    files?.forEach { file ->
        println("==============$file===============")
        val content = file.readText().trim()
            .split("\n".toRegex())
        val figures = content.let {shapesString->
            Array(shapesString.size){id -> getShape(shapesString[id])}
        }
        println("Incorrect parameters amount: ${figures.filter { it == null }.size}")
        val figures2D = figures.filter { it?.dimension() == 2 }
        val figures3D = figures.filter { it?.dimension() == 3 }
        println("2D figure with max square: ${figures2D.maxBy { it?.volume() ?: 0.0 }}")
        println("3D figure with max volume: ${figures3D.maxBy { it?.volume() ?: 0.0 }}")

    }
}
fun main() {
//    test1()
//    test2()
    solution()
}