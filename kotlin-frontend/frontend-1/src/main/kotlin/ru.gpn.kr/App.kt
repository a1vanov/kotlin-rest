package ru.gpn.kr

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
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
fun main() {
//    requireAll(require.context("kotlin", true, js("/\\.css$/")))
    GlobalStyles.inject()
    App.start()
}

private object AppScope : CoroutineScope {
    override val coroutineContext = Job()
}

private object App {
    val rootEl: Element = getRootEl()

    fun start() {
        val page = getPage()
        startPage(page);
    }

    private fun startPage(page: String) {
        when (page) {
            "getUserPage" -> getUserPage(rootEl)
            "welcomeUserPage" -> welcomeUserPage(rootEl)
            else -> {
                console.log("unknown page $page")
            }
        }
    }

    private fun getPage(): String {
        return rootEl.getAttribute("data-page")
                ?: throw IllegalStateException("Attribute 'data-page' not specified for root element")
    }

    private fun getRootEl(): Element {
        return document.getElementById("root")
                ?: throw IllegalStateException("'root' element not found")
    }

    private fun getUserPage(root: Element) {
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

    private fun welcomeUserPage(root: Element) {
        document.bgColor = "green"

        render(root) {
            h1 {
                +"Welcome Page"
            }
        }
        render(root) {
            child(WelcomeUser::class) {
                attrs.coroutineScope = AppScope
            }
        }
    }
}





