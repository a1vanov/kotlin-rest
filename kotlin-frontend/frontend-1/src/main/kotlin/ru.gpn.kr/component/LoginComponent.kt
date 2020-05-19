package ru.gpn.kr.component

import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.dom.div
import react.dom.form
import react.RComponent
import react.RState
import react.dom.button
import react.dom.fieldSet
import react.dom.input
import react.dom.label
import react.dom.legend
import react.setState


class LoginFormState(var login: String, var password: String, var disabled: Boolean, var errorMessage: String?) : RState

class LoginComponent : RComponent<GetUserProps, LoginFormState>() {

    init {
        state = LoginFormState("", "", false, "")
    }

    override fun RBuilder.render() {
        div {
            form(classes = "pure-form pure-form-stacked") {
                legend { +"Login" }

                fieldSet(classes = "pure-group") {
                    input(type = InputType.text, name = "login") {
                        attrs {
                            value = state.login
                            placeholder = "Login"
                            disabled = state.disabled

                            onChangeFunction = {
                                val target = it.target as HTMLInputElement

                                setState {
                                    login = target.value
                                }
                            }
                        }
                    }
                    input(type = InputType.password, name = "password") {
                        attrs {
                            value = state.password
                            placeholder = "Password"
                            disabled = state.disabled

                            onChangeFunction = {
                                val target = it.target as HTMLInputElement

                                setState {
                                    password = target.value
                                }
                            }
                        }
                    }
                }

                state.errorMessage?.takeIf(String::isNotEmpty)?.let { message ->
                    label {
                        +message
                    }
                }

                button(classes = "pure-button pure-button-primary") {
                    +"Login"
                    attrs {
                        disabled = state.disabled

                        onClickFunction = {
                            it.preventDefault()
                            doLogin()
                        }
                    }
                }
            }
        }
    }

    private fun doLogin() {
        setState {
            disabled = true
        }
//        async {
//            val user = login(state.login, state.password)
//            loggedIn(user)
//        }.catch { err -> loginFailed(err) }
    }

//    private fun loggedIn(user: User) {
//        props.userAssigned(user)
//    }

    private fun loginFailed(err: Throwable) {
//        if (err is LoginOrRegisterFailedException) {
//            setState {
//                disabled = false
//                errorMessage = err.message
//            }
//        } else {
//            console.error("Login failed", err)
//            setState {
//                disabled = false
//                errorMessage = "Login failed: please reload page and try again"
//            }
//        }
    }
}
