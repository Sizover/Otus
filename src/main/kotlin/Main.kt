/**
 * В main применен вызов DSL функции testAround с вынесенной за скобки в лямбду функцией
 * функция testAround определена нами заранее в Dsl.kt
 * testAround сначала создает экземпляр класса TestAround и затем вызывает функцию из лямбды
 * Окружив контекстом Класса TestAround вызываем его функцию runTest
 * передавая ей анализируемый на before after класс
 */

fun main() {
    Ls1<Steps>().runTest(Steps()) { justTestFun() }

    println("==================== пример вызова через  DSL ================================")

    ls1 {
        runTest(Steps()) { justTestFun() }
    }

    println("==================== Передача в вызов 'BeforeOnlyTestClass()' ================================")

    ls1 {
        runTest(BeforeOnlyTestClass()) { justTestFun() }
    }

    println("==================== Передача в вызов 'BeforeAndAfterTestClass()' ================================")

    ls1 {
        runTest(BeforeAndAfterTestClass()) { justTestFun() }
    }

    println("==================== Передача в вызов 'BeforeTwiceAndAfterTwiceTestClass()' ============================")

    ls1 {
        runTest(BeforeTwiceAndAfterTwiceTestClass()) { justTestFun() }
    }

    println("==================== Передача в вызов 'AfterOnlyTestClass()' ================================")

    ls1 {
        runTest(AfterOnlyTestClass()) { justTestFun() }
    }

    println("==================== Передача в вызов 'EmptyTestClass()' ================================")

    ls1 {
        runTest(EmptyTestClass()) { justTestFun() }
    }

}

fun justTestFun(){
    println("Логика теста \"justTestFun\"")
}

class Steps{
    fun beforeOne(){
        println("Логика метода \"beforeOne\"")
    }
    fun beforeTwo(){
        println("Логика метода \"beforeTwo\"")
    }
    fun notbefore(){
        println("Логика метода \"notbefore\"")
    }
    fun someFun(){
        println("Логика метода 'some'")
    //Изоляторы кавычек ставились не потому что нужны были какие-то кавычки,
    // а именно потому что двойные имхо красивее, читабильнее
    // и придают тектсту вид полновесной литературно-технической... эм... строки))
    }
    fun afterOne(){
        println("Логика метода \"afterOne\"")
    }
    fun afterTwo(){
        println("Логика метода \"afterTwo\"")
    }
    fun notafter(){
        println("Логика метода \"notafter\"")
    }
}