package ru.gpn.kr

import org.w3c.dom.Element
import react.dom.h1
import react.dom.render
import ru.gpn.kr.component.GetUserComponent
import ru.gpn.kr.component.WelcomeUser
import kotlin.browser.document

//deprecated - https://github.com/Kotlin/kotlin-fullstack-sample/blob/master/frontend/src/org/jetbrains/demo/thinkter/Login.kt
//https://github.com/Kotlin/kotlin-full-stack-application-demo.git
//https://github.com/JetBrains/create-react-kotlin-app
//https://habr.com/ru/post/418553/


/**
 * @author User on 24.04.2020.
 */
fun main(args: Array<String>) {
//    requireAll(require.context("kotlin", true, js("/\\.css$/")))
    val rootEl = document.getElementById("root")

    if (rootEl == null) {
        console.log("'root' element not found")
        return
    }

    val page = rootEl.getAttribute("data-page")

    if (page == null) {
        console.log("Attribute 'data-page' not specified for root element")
        return
    }

    GlobalStyles.inject()

    when (page) {
        "getUserPage" -> getUserPage(rootEl)
        "welcomeUserPage" -> welcomeUserPage(rootEl)
        else -> {
            console.log("unknown page $page")
        }
    }
}

fun getUserPage(root: Element) {
    document.bgColor = "blue"

    render(root) {
        h1 {
            +"Home Page. Hello, React+Kotlin/JS!"
        }
    }

    render(root) {
        child(GetUserComponent::class) {}
    }
}

fun welcomeUserPage(root: Element) {
    document.bgColor = "green"

    render(root) {
        h1 {
            +"Welcome Page"
        }
    }
    render(root) {
        child(WelcomeUser::class) {}
    }
}
