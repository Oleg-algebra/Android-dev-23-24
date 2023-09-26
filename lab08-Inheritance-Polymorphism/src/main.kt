import java.io.File

fun getShape(description: String): Shape?{
    val params = description.trim().split("\\s++".toRegex()).toMutableList()

    val type = params.removeAt(0)
    val pDs = params.map { it.toDouble() }
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

}
fun main() {
    val files = File("src/resourses").listFiles()
    files?.forEach {
        println("==============$it===============")
        val content = it.readText().trim()
            .split("\n".toRegex())
        val figures = content.let {shapesString->
            Array(shapesString.size){id -> getShape(shapesString[id])}
        }
        val figures2D = figures.filter { it?.dimension() == 2 }
        val figures3D = figures.filter { it?.dimension() == 3 }
        println("2D figure with max square: ${figures2D.maxBy { it?.volume() ?: 0.0 }}")
        println("3D figure with max volume: ${figures3D.maxBy { it?.volume() ?: 0.0 }}")

    }
}