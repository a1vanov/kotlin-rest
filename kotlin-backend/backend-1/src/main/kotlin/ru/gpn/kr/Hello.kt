package ru.gpn.kr

import java.lang.Exception

fun main(args: Array<String>) {
    println("Hello, World")
//    val a = A(22, 33)
    val q1 = DataComp(1, "e")
    val q2 = DataComp(1, "e")

    val bb = (q1.a ?: throw Exception("fff")) == q2.a

    println("bb=${bb}")
}

fun parseInt(s: String): Int? {
    fun a(s2: String): String {
        return s2 + "2"
    }

    return a(s).toIntOrNull()
}

data class DataComp(val a: Int?, val b: String?)

open class DataA(val a: A = A(1))

data class DataC(val c: C) : DataA()


open class A constructor(val a: Int) {
    var b: Int = 0

    constructor(a: Int, b: Int) : this(a) {
        this.b = b
    }

    open fun print() {
        println("a=$a, b=$b")
    }
}

class C(a: Int, b: Int, val c: Int) : A(a, b) {
    override fun print() {
        println("a=$a, b=$b, c=$c")
    }
}

public inline fun sus(crossinline block: () -> Unit) {
    var a = object : Any() {
        fun a() = block()
    }
}

public suspend inline fun <T> suspendCancellableCoroutine(crossinline block: (Int) -> Unit) {

}

fun r() {
    sus() {
        var a = 1
        return@sus
    }
}

//public suspend fun <T> Int.await(): T = sus { cont: Int ->
//    this@await.then(
//            onFulfilled = { cont.resume(it) },
//            onRejected = { cont.resumeWithException(it) })
//}

object ASingleton : A(1)

class B(val b: Int) {
    companion object {
        fun create(b: Int): B = B(b)
    }
}