
/**
 * Здесь определяется функция DSL  Ls1
 * Ls1 и есть основной окружающий класс
 * а initializer передаваемая ему функция- в этом примере justTestFun()
 * по правилам DSL она выносится за скобки при вызове в лямбду
 * Затем она используется в Main.kt
 */
fun <T : Any> ls1(initializer: Ls1<T>.() -> Unit): Ls1<T> = Ls1<T>().also{ it.initializer() }
/*{  // это то же самое длиннее, но понятнее
    val Ls1 = Ls1<T>()
    Ls1.initializer()
    return Ls1
}*/
