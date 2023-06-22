import kotlin.reflect.full.declaredMemberFunctions


class Ls1<T: Any>: TestRunner<T> {
    override fun runTest(steps: T, test: () -> Unit) {
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