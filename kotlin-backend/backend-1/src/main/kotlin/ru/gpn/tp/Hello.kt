package ru.gpn.tp

fun main(args: Array<String>) {
    println("Hello, World")

    val a = A(22, 33)

    a.print()
    a.b = 55
    a.print()

    ASingleton.print()

    val c = C(1, 2, 3)
    c.print()

    val dataC1 = DataC(C(2, 7, 4))
    val dataC2 = dataC1.copy()
    dataC1.a.print()
    dataC2.a.print()
}

fun parseInt(s: String): Int? {
    return s.toIntOrNull()
}

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

object ASingleton : A(1)

class B(val b: Int) {
    companion object {
        fun create(b: Int): B = B(b)
    }
}