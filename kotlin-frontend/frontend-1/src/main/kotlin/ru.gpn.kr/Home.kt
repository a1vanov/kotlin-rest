package ru.gpn.kr

import kotlinx.css.*
import org.w3c.dom.get
import react.RBuilder
import react.dom.button
import react.dom.h1
import react.dom.div
import react.dom.span
import react.dom.render
import styled.css
import styled.styledDiv
import kotlin.browser.document

//deprecated - https://github.com/Kotlin/kotlin-fullstack-sample/blob/master/frontend/src/org/jetbrains/demo/thinkter/Login.kt
//https://github.com/Kotlin/kotlin-full-stack-application-demo.git
//https://github.com/JetBrains/create-react-kotlin-app

//import kotlinx.css.*


//import kotlinx.html.*
//import kotlinx.html.dom.*

/**
 * @author User on 24.04.2020.
 */
fun main() {
    GlobalStyles.inject()
    app()
}

fun app() {
//    requireAll(require.context("kotlin", true, js("/\\.css$/")))
    document.bgColor = "blue"

    val root = document.getElementById("root")
    render(root) {
        h1 {
            +"Home Page. Hello, React+Kotlin/JS!"
        }
    }

    val body = document.getElementsByTagName("body")[0]
    render(body) {
        styledDiv {
            css {
                position = Position.absolute
                top = 10.px
                right = 10.px
            }
            +"Это styledDiv"
        }
    }

    render(root) {
        button { +"submit" }
    }

    render(root) {
        button { +"page2" }
    }


    /*
    document.body!!.append.div {
        h1 {
            +"Welcome to Kotlin/JS!"
        }
        p {
            +"Fancy joining this year's "
            a("https://kotlinconf.com/") {
                +"KotlinConf"
            }
            +"?"
        }
    }
        */
}
