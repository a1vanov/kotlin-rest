package ru.gpn.kr.component

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLElement
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.fieldSet
import react.dom.input
import react.dom.label
import react.dom.legend
import react.setState
import org.w3c.dom.events.Event

interface LoginState : RState {
    var username: String
    var password: String
    var logged: Boolean
}

class LoginComponent1 : RComponent<RProps, LoginState>() {

    init {
        state.logged = false
    }

    override fun RBuilder.render() {

        if (state.logged) {
            button {
                +"Logout"
                attrs.onClickFunction = {
                    setState { logged = false }
                }
            }

            return
        }

        fieldSet {
            legend { +"Login" }
            label { +"Username: " }
            input(type = InputType.text, name = "login") {
                attrs {
                    value = state.username
                    placeholder = "Login"

                    onChangeFunction = {
                        val target = it.target as HTMLInputElement

                        setState {
                            username = target.value
                        }
                    }
                }
            }

            label { +"Password: " }
            input(type = InputType.password, name = "password") {
                attrs {
                    value = state.password
                    placeholder = "Password"

                    onChangeFunction = {
                        val target = it.target as HTMLInputElement

                        setState {
                            password = target.value
                        }
                    }
                }
            }

            button {
                +"Login"
                attrs.onClickFunction = {
//                        val gh = GitHub(User(state.username, state.password))
//                        gh.getUser()
//                                .then {
//                                    setState {
//                                        logged = true
//                                    }
//                                }
                }
            }
        }


    }
}

private fun doLogin() {
//    setState {
//        disabled = true
//    }
//    async {
//        val user = login(state.login, state.password)
//        loggedIn(user)
//    }.catch { err -> loginFailed(err) }
}

//private fun loggedIn(user: User) {
////    props.userAssigned(user)
//}

private fun loginFailed(err: Throwable) {
//    if (err is LoginOrRegisterFailedException) {
//        setState {
//            disabled = false
//            errorMessage = err.message
//        }
//    } else {
//        console.error("Login failed", err)
//        setState {
//            disabled = false
//            errorMessage = "Login failed: please reload page and try again"
//        }
//    }
}

fun RBuilder.loginForm() = child(LoginComponent1::class) {
}