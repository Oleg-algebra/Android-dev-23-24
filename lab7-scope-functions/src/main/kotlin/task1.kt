/*
Scope function.
1. Опишіть дата клас Vehicle (Транспортний засіб), що має поля:
Марка, модель, рік випуску та номерний знак.
•    В методі main() cтворіть екземпляр класу Vehicle ініціалізувавши
його поля за допомогою scope-функції apply.
•    Виведіть дані цього екземпляру класу під час його створення (scope-функція also).
•    Виведіть дані про автомобіль, scope-функцію with у такому вигляді
Марка = Honda
Модель = Civic
Рік випуску: 2020
Номерний знак: КА3344ВІ

•    Опишіть окрему функцію для створення екземплярів класу Vehicle марки
Honda моделі Civic. Функція на вхід має приймати рік випуску та номерний знак моделі.
•    Винесіть оголошення змінної, що зберігає посилання на створений об’єкт класу Vehicle
у глобальну область видимості та вкажіть, що вона може бути Nulable.
•    Виведіть дані про автомобіль, використовуючи вищенаведену змінну у такому вигляді
Марка = Honda
Модель = Civic
Рік випуску: 2020
Номерний знак: КА3344ВІ
використовуючи scope-функцію let разом з перевіркою на нулабельність.
 */

data class Vehicle(var mark: String = "Audi",
                   var model: String = "Q9",
                   var year: Int = 2010,
                   var licensePlate: String = "AA0000BB")

fun hondaCivic(year: Int, licensePlate: String) = Vehicle(
    "Honda",
    "Civic",
    year,
    licensePlate,
)
var vehicleGlobal: Vehicle? = null

fun main() {
    println("===============================")
    val vehicle = Vehicle()
        .apply {
//            println("apply function running ...")
        mark = "BMW"
        model = "X6"
        year = 2009
        licensePlate = "AA7777BB"
    }
        .also {
//            println("also function running...")
        println(it)
    }
    with(vehicle){
        println("Car $mark $model, $year manufactured with licensePlate: $licensePlate")
    }
    println("===============================")
    val vehicle1 = Vehicle().apply {
        mark = "Honda"
        model = "Civic"
        year = 2009
        licensePlate = "DD5555DD"
    }
    with(vehicle1){
        println("Марка = $mark")
        println("Модель = $model")
        println("Рік випуску: $year")
        println("Номерний знак: $licensePlate")
    }
    println("==================================")
    vehicleGlobal = hondaCivic(2020,"II9090PP")
    vehicleGlobal?.let {
        println("Марка = ${it.mark}")
        println("Модель = ${it.model}")
        println("Рік випуску: ${it.year}")
        println("Номерний знак: ${it.licensePlate}")
    }
}