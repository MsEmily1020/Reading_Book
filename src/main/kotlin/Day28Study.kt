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

// companion object를 이용한 클래스 변수, 상수, 메서드 정의
class MyClass(var x: Int) {
    fun myMethod() {}

    // static 과 비슷 ex) MyClass.classVar 로 접근
    companion object {
        var classVar = 100
        val CONSTANT = 200
        fun classMethod() {}
    }
}

// 생성자가 없는, class 키워드를 쓰지 않고 object 키워드를 써서 클래스 정의
object SingletonClass {
    // 생성자를 아예 못 씀
    // 자바와 같이 중괄호 안에다가 필드 만듦
    var x = 100
    fun increaseX() {
        x++
    }

    fun printX() {
        println(x)
    }
}

fun main(args: Array<String>) {
    var inner = Outer.Inner(100)

    var outer2 = Outer2(100)
    var inner21 = outer2.Inner2(200)
    var inner22 = outer2.Inner2(300)

    println(MyClass.classVar)
    println(MyClass.CONSTANT)
    MyClass.classMethod()

    println(SingletonClass.x)
    SingletonClass.increaseX()
    SingletonClass.printX()


}