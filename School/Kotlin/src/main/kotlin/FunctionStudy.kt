import javax.swing.JButton

// void : Unit 생략 가능
fun printHello() {
    println("Hello")
}

// 변수 : 타입
// return 값 있음, 생략 불가능
fun add(a: Int, b: Int) : Int {
    // a = 200 , 오류 : a를 val(상수) 취급
    return a + b
}

// : Int 반환 타입 생략 -> 추론 가능 (return을 쓰지 않고 =을 쓴다면)
// Int = 30 : default 값 생성 가능
fun add2(a: Int, b: Int = 30) = a + b

// String + String = String
fun add3(a: Int, b: String) = a.toString() + b

fun getBigger(a: Int, b: Int) = if(a > b) a else b

fun interface MyInterface {
    fun method(i: Int): String
}

fun main(args: Array<String>) {
    printHello()
    println("a + b : " + add( 10, 3))
    println("a + b : " + add2(4))
    println("String + String : " + add3(2023, " Happy"))
    println("a > b : " + getBigger(3, 4))

    // 이름이 없는 클래스 : 생성자x, 1회용 객체
    // class A {}, A a = new A() 따로 안하고 A a = new A() {}를 함
    var myImpl = object : MyFunctionalInterface {
        override fun method(i: Int?): String {
            TODO("Not yet implemented")
        }
    }

    var myImpl2 = MyFunctionalInterface { i : Int ->
        println("say something")
        "Hello" + i
    }

    var myImpl3 = MyFunctionalInterface { i ->
        "Hello" + i;
    }

    var myImpl4 = MyFunctionalInterface { "Hello" + it }

    var btn : JButton = JButton("Click")
    btn.addActionListener {

    }

    var myImpl5 = MyAnotherInterface { i1, i2 -> "Hello "}

    var myImpl6 = MyAnotherInterface2 { "Hello" }

    var myImpl7 = object : MyNonFunctionalInterface {
        override fun method1(i: Int?): String {
            return "a"
        }
        override  fun method2(i: Int?): String {
            return "a"
        }
    }
}