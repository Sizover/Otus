interface TestRunner {

    fun <T> RunTest(steps: T, test:() -> Unit)

}