class Car(var speed: Int, var isMoving: Boolean = false) {
    fun accelerate() {
        speed += 10
    }

    fun decelerate() {
        speed -= 10
        if(speed < 0) speed = 0
    }

    fun move() {
        isMoving = true
    }
}

open class Person(var name: String, var age: Int) {
    open fun sayName() {
        println("My name is ${name}")
    }

    fun sleep(hour: Int) : Int {
        println("${hour} 시간동안 ${name}이가 잠을 잡니다.")
        return hour
    }
}

// 오버라이딩이나 상속을 받으려면 해당 메소드에 open 쓰기
class Emplyee(name: String, age: Int, var company: String) : Person(name, age) {
    fun work() {
        println("일 합니다.")
        super.sleep(8)
    }

    override fun sayName() {
        println("일꾼이 이름을 말합니다.")
    }
}

// 데이터 클래스
data class PointData(var x: Int, var y: Int)
class PointNoData(var x: Int, var y: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PointNoData

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

    override fun toString(): String {
        return "PointNoData(x=$x, y=$y)"
    }
}

// 열거형 클래스 : 상수만 정의함
enum class Color {
    RED, GREEN, BLUE
}

// 확장 함수
fun String.removeAllSpace() : String {
    return this.replace(" ", "")
}

fun main(args: Array<String>) {
    var c = Car(10, true)
    c.accelerate()
    c.decelerate()
    c.move()

    var e = Emplyee("John", 20, "Samsung")
    e.work()
    e.sayName()

    // is : 타입확인
    println(e is Emplyee)
    // println(e is Car)
    println(e !is Person)
    println(e is Any)

    // 업캐스팅
    var p : Person = e

    // 다운캐스팅
    // as : 형변환
    var ee : Emplyee = p as Emplyee

    fun method(any: Any) {
        var dd = any as? Car
        println(dd)
    }
    method(p)

    // 스마트 캐스트
    var str : Any = "Hello"
    if(str is String) {
        str.trim()
    }


    var p1 = PointNoData(1, 2);
    var p2 = PointNoData(3, 4);

    // p1 == p2의 결과는?
    // == : equal, === : ==
    println(p1 == p2)
    println(p1 === p2)
    println(p1)
    println(p2)

    var c1: Color = Color.RED
    if(c1 == Color.RED) {
        println("빨간색!")
    }

}