import kotlin.reflect.full.declaredMemberFunctions

/**
 * Константы с подстрокой, определяющей методы в имени которых BEFORE и AFTER
 */
private const val BEFORE = "before"
private const val AFTER = "after"
/**
 *  Создайте класс реализующий интерфейс TestRunner<T>
 */

class Ls1<T: Any>: TestRunner<T> {
    /**
     * Внутри класса переопределите метод runTest
     * Сделанный и настроенный  runTest вызывается из main:
     * runTest(BeforeTwiceAndAfterTwiceTestClass()) { println("§ BeforeTwiceAndAfterTwiceTestClass RUNNING") }
     * и передается класс в котором сидят запускаемые функции тестов (в т.ч. м.б. before* и after*):
     * BeforeTwiceAndAfterTwiceTestClass(), BeforeAndAfterTestClass, AfterOnlyTestClass, BeforeOnlyTestClass, EmptyTestClass
     * на место функции test сюда main передает  justTestFun()")
     */
    override fun runTest(steps: T, test: () -> Unit) {
        println("####################### Передача в вызов '${steps::class.simpleName}()' ##############################")
//        fun beforeAfter(beforeAfter:String) =
//            steps::class.declaredMemberFunctions.filter { it.name.startsWith(beforeAfter) }
//                .forEach { stepsKF ->
//                    println("Будет вызван метод группы '$beforeAfter'' - ${stepsKF.name}")
//                    stepsKF.call(steps)
//                    println("Был вызван метод группы '$beforeAfter'' - ${stepsKF.name}")
//                }
        /**
         * Внутри этого метода необходимо сначала вызвать методы с before* из steps,
         * далее прогнать тест (запустить передаваемую функцию test),
         * и после вызвать методы с after* из steps.
         *
         */
//        beforeAfter("before")
//        test()
//        beforeAfter("after")

        //Так же что бы 100% не запутатся  с областями видимости дефолтного алиаса it (и для наглядности),
        // проставил не дефолтные алиасы, что чуть-чуть раздувает код
        steps::class.declaredMemberFunctions.filter { it.name.startsWith("before") }
            .forEach { stepsKF ->
                println("Будет вызван метод группы \"before\" - ${stepsKF.name}")
                stepsKF.call(steps)
                println("Был вызван метод группы \"before\" - ${stepsKF.name}")
            }

        test()

        steps::class.declaredMemberFunctions.filter { it.name.startsWith("after") }
            .forEach { stepsKF ->
                println("Будет вызван метод группы \"after\" - ${stepsKF.name}")
                stepsKF.call(steps)
                println("Был вызван метод группы \"after\" - ${stepsKF.name}")
            }
    }
}