//class BoxForInt(var content: Int) {
//    fun set(content: Int) {
//        this.content = content
//    }
//
//    fun get(): Int {
//        return content
//    }
//}
//
//class BoxForString(var content: String) {
//    fun set(content: String) {
//        this.content = content
//    }
//
//    fun get(): String {
//        return content
//    }
//}

class Box<T>(var content: T) {
    fun set(content: T) {
        this.content = content
    }

    fun get(): T {
        return content
    }
}

class MyPair<K, V>(var key: K, var vlaue: V)

fun<T> myPrint(prefix: String, target: T) {
    println("${prefix} : ${target}")
}

fun main(args: Array<String>) {
    var intBox = Box<Int>(100)
    var stringBox = Box("Hello")
    var stringIntPair1 = Pair<String, Int>("key1", 1234)
    var stringIntPair2 = Pair("key2", 5678)

    myPrint<Int>("myprefix", 1234)
    myPrint("myprefix", "hello")


}