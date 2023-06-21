

fun <T> main() {
    Ls1<T>().runTest(Steps(), { justFun() })
}

fun justFun(){
    println("Логика теста \"justFun1\"")
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