package ru.gpn.kr.component

import kotlinx.coroutines.experimental.async
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.jetbrains.common.inputValue
import org.jetbrains.demo.thinkter.LoginOrRegisterFailedException
import org.jetbrains.demo.thinkter.model.User
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.button
import react.dom.fieldSet
import react.dom.input
import react.dom.label


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

        if (!state.logged) {
            fieldSet {
                label { +"Username: " }
                input (type = InputType.text, name = "login"){
                    value = state.login
                    placeholder = "Login"
                    disabled = state.disabled

                    onChangeFunction = {
                        setState {
                            login = it.inputValue
                        }
                    }
                }

                label { +"Password: " }
                input {
                    [...]
                }

                button {
                    +"Login"
                    attrs.onClickFunction = {
                        val gh = GitHub(User(state.username, state.password))
                        gh.getUser()
                                .then {
                                    setState {
                                        logged = true
                                    }
                                }
                    }
                }
            }
        } else {
            button {
                +"Logout"
                attrs.onClickFunction = {
                    setState { logged = false }
                }
            }
        }

    }
}

private fun doLogin() {
    setState {
        disabled = true
    }
    async {
        val user = login(state.login, state.password)
        loggedIn(user)
    }.catch { err -> loginFailed(err) }
}

private fun loggedIn(user: User) {
    props.userAssigned(user)
}
private fun loginFailed(err: Throwable) {
    if (err is LoginOrRegisterFailedException) {
        setState {
            disabled = false
            errorMessage = err.message
        }
    } else {
        console.error("Login failed", err)
        setState {
            disabled = false
            errorMessage = "Login failed: please reload page and try again"
        }
    }
}

fun RBuilder.loginForm() = child(LoginComponent1::class) {
}