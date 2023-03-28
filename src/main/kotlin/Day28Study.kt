// 내부 클래스, 내부 인터페이스
class Outer(var x: Int) {
    fun outerMethod() {}

    class Inner(var y: Int) {
        fun innerMethod() {
            // println("${x}")
            // outerMethod()
            println("${y}")
        }
    }
    interface MyInterface {
        fun abstractMethod()
    }
}

class Outer2 (var x: Int){
    fun outerMethod() {}

    // inner로 Outer2 접근가능
    inner class Inner2 (var y: Int){
        fun innerMethod() {
            println(x)
            println(y)
            outerMethod()
        }
    }
}
interface Hello {
    interface World {
    }
}

fun main(args: Array<String>) {
    var inner = Outer.Inner(100)

    var outer2 = Outer2(100)
    var inner21 = outer2.Inner2(200)
    var inner22 = outer2.Inner2(300)

}