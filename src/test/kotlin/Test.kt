import org.junit.jupiter.api.Test

class Test {
    @Test
    fun <T> `Функция созданная потому что в мэйне видимо не катит дженерик` (){//т.к. исчезал вызов ранера если объявить мэйн как работающий с дженериком
        Ls1<T>().runTest(Steps() as T, { justTestFun() })
    }
}