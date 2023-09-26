package task4


/*
4. Дано рядок у якому міститься арифметичний вираз, що складається з дійсних чисел та
знаків арифметичних операцій (+ - * /). Кожен операнд відділений від оператора арифметичних
операцій одним символом пропуску.
Нехтуючи пріоритетом арифметичних операцій підрахуйте значення цього виразу.
 */

fun main(){
//    val expr = "2 + 2 + 2 * 2 - 10 * 2"    // output: 4.0
//    val expr = "2 + 4 + 2 * 2 / 2"        // output: 8.0
//    val expr = "dljflldkj"                // output: Incorrect expression
//    val expr = "2 + 5 * 6 / 0 + 6"        // output:  ArithmeticError: DivisionByZero.
    val expr = readln()
    val tokens = expr.split("\\s+".toRegex())

    var i = 0
    var result = 0.0
    try {
        result = tokens[0].replace(',','.').toDouble()
        while(i < tokens.size){
            val operation = tokens[++i]
            val number = tokens[++i].replace(',','.').toDouble()
            when(operation){
                "+" -> result+=number
                "-" -> result-=number
                "*" -> result*=number
                "/" -> {
                    if (number==0.0) throw ArithmeticException()
                    result /= number
                }
            }
        }

    }catch (e: IllegalArgumentException){
        println("Incorrect expression.")
    }catch (_: IndexOutOfBoundsException){
        println("$expr = $result")
    }catch (e: ArithmeticException){
        println("ArithmeticError: DivisionByZero.")
    }
}