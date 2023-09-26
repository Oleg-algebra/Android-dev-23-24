/*
1. Опишіть клас Employee (Працівник), що має поля Прізвище, ім’я та посада.
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

//data class Employee(var firstName: String, var lastName: String, var position: String)


class Employee(var firstName: String, var lastName: String, var position: String){
    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if (other is Employee){
            if (other.firstName != firstName) return false
            if (other.lastName != lastName) return false
            if (other.position != position) return false
            return true
        }
        return false
    }

    override fun hashCode(): Int {
        var hash = firstName.hashCode()
        hash = hash * 31 + lastName.hashCode()
        hash = hash * 31 + lastName.hashCode()
        return hash
    }

    override fun toString(): String {
        return "Employee(firstName= $firstName, lastName= $lastName, position= $position)"
    }

    operator fun component1() = firstName
    operator fun component2() = lastName
    operator fun component3() = position

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        position: String = this.position,
    ) = Employee(firstName, lastName, position)

}

fun compareObjects(employee1: Employee, employee2: Employee){
    if(employee1 == employee2){
        println("objects are equal")
    }else{
        println("objects are different")
    }
}

fun compareReferences(employee1: Employee, employee2: Employee){
    if (employee1 === employee2){
        println("references are the same")
    }else{
        println("references are different")
    }
}

fun main(){
    val employee1 = Employee("Jack", "Sparrow","captain")
    val employee2 = Employee("Mark", "Zuckenbergh", "CEO-Facebook")
    val employee3 = Employee("Jack", "Sparrow","captain")
    val employee4 = employee1
    val employee5 = employee1.copy()

    println("=====HashCodes======")
    println("employee1 hash= ${employee1.hashCode()}")
    println("employee3 hash= ${employee3.hashCode()}")
    println("employee2 hash= ${employee2.hashCode()}")

    println("=========ObjectsComparison========")
    compareObjects(employee1,employee2)
    compareObjects(employee1,employee5)

    println("========ReferencesComparison=======")
    compareReferences(employee1,employee5)
    compareReferences(employee1,employee4)

    println("=======Unpacking=======")
    val (firstName,lastName,position) = employee3
    println(firstName)
    println(lastName)
    println(position)
}