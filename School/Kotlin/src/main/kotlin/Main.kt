fun main(args: Array<String>) {
    // primartive type x

    var a = 100
    var b : String = "Hello"
    var c : Int = 200

    // val : 상수
    val d = 300
    // d = 400
    val PI = 3.14
    var f = 1.234F

    // 형변환
    var i = f.toInt()

    // 문자열들
    var s3 = """
        파이썬에도 있는내용
    """.trimIndent()

    var num1 = 100
    var num2 = 200
    var str = "num1 : ${num1} num2 : ${num2 * 2}"
    println(str)

    // 아무타입이나
    // var anyValue = 100
    var anyValue : Any
    anyValue = 100
    println("AnyType Int : " + anyValue)
    anyValue = "Hello"
    println("AnyTpe String : " + anyValue)

    // null 저장
    // var n = 100
    // n = null : Int값이 아니라서 오류
    var n : Int? = 100
    n = null

    var sss : String? = "Hello"
    sss = null

    //NullPointerException 실행됨 String 타입이므로 (? x)
    var s = "Hello"
    println("length : " + s.length)
    println("Hello 문자열 자르기 : " + s.substring(0, 3))
    println("문자열부터 시작 하는지 : " + s.startsWith("He"))

    var s2 : String? = null
    // println(s2.length)

    // NullPointerException 실행됨 String 타입이므로 (? x)
    // println(s2!!.length) : String? -> String

    println("s2?.length : " + s2?.length) // null 반환

    // substring에서 부터 null 반환
    // ?. : null-safe operator
    // !!. : non-null asserted operator
    println("s2?.substring(0, 3)?.lowercase()?.length : " + s2?.substring(0, 3)?.lowercase()?.length)

    var i2 : Int? = 100
    var ii : Int = i2!! //i2 : null일 경우 NullPointerException 발생

    // String형도 되는 거고 null도 됨 -> 판단 : s4가 String이면 if문에 판단 -> true : print출력 -> 아~! null이 아니구나 판단
    //                                판단 : s4가 null이면 if문에 판단 -> print출력 x -> 아~! null이구나

    var s4 : String? = null
    if(s4 != null) {
        println(s4.length)
    }

    // ?: 엘비스 연산자 : 왼쪽 값이 null이면 오른쪽 값 반환
    var one = null ?: 1
    println("null ?: 1 : " + one)

    var c1: String? = null
    var len = c1?.length ?: 0
    println("c1?.length ?: " + len)

    // if (조건식) true값 else false값
    var len1 = if(c1?.length == null) 0 else c1.length
    println("if(c1.length == null) 0 else c1.length : " + len1)

    var s5 = "Hello"
    // var i4 = s5.toInt() // String -> Int (x)
    var i4 = s3.toIntOrNull() // String -> Int false -> null값 반환
    println("s3.toIntOrNull() : " + i4)

    // 1) 주석 종류
    //

    // 2) 주석 종류
    /**/

    // 3) 주석 종류
    /*
    /*
    /*

     */
     */
     */

    // null 관련 연산자
    // ?. : 값을 포함하지 않은 변수를 출력하려고 할 때 null로 출력시킴
    // !!. : null을 포함하지 않은 타입으로 만듦 ex (String? -> String)
    // ?: : 왼쪽 값이 null이면 오른쪽 값 변환

    // 타입 추론 -> 오른쪽 대입값을 보고 타입을 유추

    // in 연산자
    // 1. 배열과 같은 여러 값이 있는 곳에 특정 값이 있는지 검사
    // 2. for 내부에서 배열, 리스트, 범위 객체등을 순회하는데 사용

    // 1.
    var list = listOf(1, 2, 3)
    println("list 값에 1이 있는지 " + (1 in list))      // true
    println("list 값에 4가 있는지 " + (4 in list))      // false

    var list2 = listOf(1, "Hello")

    var list3 = listOf("happy", "sad", "mirim")
    println("list 값에 happy가 있는지 " + ("happy" in list2))       // true
    println("list 값에 good이 있는지 " + ("good" in list2))        // false

    // 2.
    for(num in 1 .. 10) {
        println("num : " + num)
    }

    for(l in list3) {
        println("list : " + l)
    }

    // 제어문 -> 분기문 ex if, switch, 반복문 ex for, while
    var score = 100

    // 1. if구문

    // var grade: String = ""       // 대입한 값이 없기 떄문에 String으로 지정(타입추론x)

    // if(score >= 90) {
    //    grade = "A"
    // } else if(score >= 80) {
    //    grade = "B"
    // } else {
    //    grade = "C"
    // }

    // println("점수 : " + grade)

    // 2. if표현식
    var grade = if(score >= 90) {
        println("if표현식")
        println("신난다")
        var ccc = 100
        "A".lowercase()         // 무조건 마지막 문이 grade에 들어감
    } else if(score >= 80) {
        "B" + "+"
    } else {                    // else가 반드시 있어야 함(80미만이면 어떻게 할건지가 없음)
        "C"
    }

    println("점수 : " + grade)

    // switch - kotlin 버전
    // 1. switch구문
    var num = 1
    when(num) {
        1 -> {
            println("switch 구문")
            println("두 줄")
            println("one")
        }
        (1.inc()) -> println("two")     // inc() -> 증감 연산자
        (1 * 3) -> println("three")
        else -> println("no match")     // 필수x (구문)
    }

    // 2. switch표현식
    var a1 = 10
    var b1 = 20
    var op = "+"
    var result = when(op) {
        "+" -> {
            println("switch 표현식")
            a1 + b1
        }
        "-" -> a1 - b1
        else -> null            // 필수o (표현식), Int? 타입
    }

    println("switch 표현식 : " + result)

    
    // println("Hello World!")
}