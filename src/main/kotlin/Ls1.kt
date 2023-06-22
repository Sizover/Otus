import kotlin.reflect.full.declaredMemberFunctions


class Ls1<T: Any>: TestRunner<T> {  // вставлено: Any тогда не надо !!
    override fun runTest(steps: T, test: () -> Unit) {
        //Компилятор ругался на налбл защиту, но не принимал "?", и требовал только "!!"
        // пришлось сделать налбл защиту через let - можно см ниже
        //Так же что бы 100% не запутатся  с областями видимости дефолтного алиаса it (и для наглядности),
        // проставил не дефолтные алиасы, что чуть-чуть раздувает код
        steps::class.declaredMemberFunctions.filter { it.name.startsWith("before") }
            .forEach { stepsKF ->
                println("Будет вызван метод группы \"before\" - ${stepsKF.name}")
                stepsKF.call(steps)
                println("Был вызван метод группы \"before\" - ${stepsKF.name}")
            }

//        steps?.let {stps ->
//            stps::class.declaredMemberFunctions.filter { it.name.startsWith("before") }
//                .forEach { stepsKF ->
//                    println("Будет вызван метод группы \"before\" - ${stepsKF.name}")
//                    stepsKF.call(steps)
//                    println("Был вызван метод группы \"before\" - ${stepsKF.name}")
//                }
//        }
        test()
        //из-за желания сделать красиво, сделал вот так, но получилось не очень,
        // потому как хотелось вытащить имя функции переданной в параметре test,
        // но мозгов не хватает дотумкать как, поэтому будет как есть))
       // println("Был запущен тест \"${test.javaClass.enclosingMethod.name}\"") - этого здесь не надо, да и работает неправильно - "invoke"
        // тест сам логгирует запись

        steps?.let {stps ->
            stps::class.declaredMemberFunctions.filter { it.name.startsWith("after") }
                .forEach { stepsKF ->
                    println("Будет вызван метод группы \"after\" - ${stepsKF.name}")
                    stepsKF.call(steps)
                    println("Был вызван метод группы \"after\" - ${stepsKF.name}")
                }
        }
    }
}