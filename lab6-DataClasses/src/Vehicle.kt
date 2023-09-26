/*
2. Опишіть дата клас Vehicle (Транспортний засіб), що має поля:
Марка, модель, рік випуску та номерний знак.
•    Створіть кілька екземплярів цього класу
•    Виведіть екземпляри цих класів в консоль використовуючи функцію println().
•    Здійсніть операції порівняння цих екземплярів за значенням та посиланням.
•    Для цього класу реалізуйте методи порівняння, генерування хеш-значення та toString().
•    Перетворіть цей клас у Дата клас.
•    Розпакуйте дані екземпляру цього класу використовуючи деструктивний оператор.
•    Зробіть копію цього використовуючи метод copy().
•    Виведіть на екран значення цих об’єктів, їх хешкоди та результати порівняння
(за значеннями та посиланнями).
•    Видаліть ключове слово data та реалізуйте всі необхідні методи, для реалізації дата класу.
 */

//data class Vehicle(var mark: String, var model: String, var year: Int, var licensePlate: String)

class Vehicle(var mark: String, var model: String, var year: Int, var licensePlate: String){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Vehicle

        if (mark != other.mark) return false
        if (model != other.model) return false
        if (year != other.year) return false
        if (licensePlate != other.licensePlate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = mark.hashCode()
        result = 31 * result + model.hashCode()
        result = 31 * result + year
        result = 31 * result + licensePlate.hashCode()
        return result
    }

    override fun toString(): String {
        return "Vehicle(mark='$mark', model='$model', year=$year, licensePlate='$licensePlate')"
    }

    operator fun component1() = mark
    operator fun component2() = model
    operator fun component3() = year
    operator fun component4() = licensePlate

    fun copy(
        mark: String = this.mark,
        model: String = this.model,
        year: Int = this.year,
        licensePlate: String = this.licensePlate
    ) = Vehicle(mark, model, year, licensePlate)

}

fun compareObjects(vehicle1: Vehicle, vehicle2: Vehicle){
    if(vehicle1 == vehicle2){
        println("objects are equal")
    }else{
        println("objects are different")
    }
}

fun compareReferences(vehicle1: Vehicle, vehicle2: Vehicle){
    if (vehicle1 === vehicle2){
        println("references are the same")
    }else{
        println("references are different")
    }
}


fun main() {
    val vehicle1 = Vehicle("Audi", "A4", 2008,"AA8769BB")
    val vehicle2 = Vehicle("Audi", "A6", 2000,"AA8769CC")
    val vehicle3 = vehicle1.copy()
    val vehicle4 = vehicle1

    println("======HashCodes=======")
    println("vehicle1 hash= ${vehicle1.hashCode()}")
    println("vehicle3 hash= ${vehicle3.hashCode()}")
    println("vehicle2 hash= ${vehicle2.hashCode()}")

    println("=========ObjectsComparison========")
    compareObjects(vehicle1,vehicle2)
    compareObjects(vehicle1,vehicle3)

    println("========ReferencesComparison=======")
    compareReferences(vehicle1,vehicle3)
    compareReferences(vehicle1,vehicle4)

    println("=======Unpacking=======")
    val(mark,model,year,licensePlate) = vehicle1
    println("mark: $mark")
    println("model: $model")
    println("year: $year")
    println("licensePlate: $licensePlate")


}