import kotlin.reflect.full.declaredMemberFunctions

class Ls1<T>: TestRunner<T> {
    override fun runTest(steps: T, test: () -> Unit) {
        steps?.let {_steps ->
            _steps::class.declaredMemberFunctions.filter { it.name.startsWith("before") }
                .forEach { stepsKF ->
                    stepsKF.call(steps)
                    println("Был вызван метод группы \"before\" - ${stepsKF.name}")
                }
        }
        test()
        println("Был запущен тест \"${test.javaClass.enclosingMethod.name}\"")
        steps?.let {_steps ->
            _steps::class.declaredMemberFunctions.filter { it.name.startsWith("after") }
                .forEach { stepsKF ->
                    stepsKF.call(steps)
                    println("Был вызван метод группы \"after\" - ${stepsKF.name}")
                }
        }
    }
}