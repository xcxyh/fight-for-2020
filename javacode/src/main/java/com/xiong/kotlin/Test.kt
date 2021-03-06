package com.xiong.kotlin

class Test {
    // 函数和 属性重名的话  使用  Test::post 这种 成员引用会报错
    val post1: String = "haha"

    fun post() {
        println(post1)
    }

    companion object { //我是静态块
        /**
        这里面定义的静态变量跟静态方法，类似java的：static
         **/
        @JvmStatic
        fun main(args: Array<String>) {
            val a = "Kotlin"
            val b: String? = null

            println(b?.length)
            println(a.length) // ⽆需安全调⽤
        }
    }

    fun maxOf(a: Int, b: Int): Int = if (a > b) a else b
    fun printProduct(arg1: Int?, arg2: Int?) {

        if (arg1 != null && arg2 != null) {
            // 在空检测后，x 与 y 会⾃动转换为⾮空值（non-nullable）
            println(arg1 * arg2)
        }
    }

}

fun forTest() {

    val elements = listOf(1, 2, 3, 4, 5, 6, 7)
    for ((index, ele) in elements.withIndex()) {

        println("index : $index , element: $ele")

    }
    println()
    for (i in elements.indices){
        println("index : $i , element: ${elements[i]}")

    }
}

fun main() {

    val test = Test()
    // 使用 类 名 引用  要传入一个实例作为参数
    val post2 = Test::post
    // 不传一个实例参数， 报错
    post2(test)

    // 绑定应用  直接使用实例 引用
    val post1 = Test()::post
    post1()

}


