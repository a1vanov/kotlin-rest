package ru.gpn.kr

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class App

//https://github.com/winterbe/spring-kotlin-react-demo

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}