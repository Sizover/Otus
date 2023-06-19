class Ls1: TestRunner {
    override fun <T> RunTest(steps: T, test: () -> Unit) {
        steps!!::class.java.methods.filter { it.name.startsWith("before") }.forEach {
            it.invoke(steps)
            println("Был вызван метод группы \"before\" - ${it.name}")
        }
        test()
        println("Был запущен тест \"${test.javaClass.enclosingMethod.name}\"")
        steps!!::class.java.methods.filter { it.name.startsWith("after") }.forEach {
            it.invoke(steps)
            println("Был вызван метод группы \"after\" - ${it.name}")
        }
    }
}