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

    var list1 = mutableListOf<String>()
    list1.add("aaa")
    list1.add("bbb")
    list1.remove("aaa")
    list1.removeAt(0)
    println(list1)
    list1.add("a"); list1.add("b"); list1.add("c")
    var a = list1.get(0)
    var b = list1[1]
    println(list1.contains("c"))
    println(list1.size)
    var sum = list1 + listOf("e", "f")
    println(sum)

    for(item in list1) {
        println(item)
    }

    var map = mutableMapOf<String, Int>()
    map.put("hello", 1234)
    map["world"] = 5678
    println(map.get("hello"))
    println(map["hello"])
    map.remove("world")
    println(map.size)
    map.clear()
    println(map)

}