package ru.gpn.kr.component

import kotlinx.css.px
import kotlinx.css.width
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.fieldSet
import react.setState
import styled.StyleSheet
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledForm
import styled.styledInput

class GetUserStyle : StyleSheet("getUserComponent", isStatic = true) {

}

interface GetUserProps : RProps

class GetUserState(var userName: String) : RState

class GetUserComponent : RComponent<GetUserProps, GetUserState>() {
    init {
        state = GetUserState("")
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                width = 350.px
            }
            styledForm(action = "api/setUser") {
                attrs {
                    onSubmitFunction = ::handleSubmit
                }
                fieldSet(classes = "pure-group") {
                    styledInput(type = InputType.text, name = "userName") {
                        attrs {
                            placeholder = "имя пользователя"
                            onChangeFunction = ::handleChange
                        }
                    }
                    styledInput(type = InputType.submit) {
//                        attrs {
//                            onClickFunction = {
//                                it.preventDefault()
////                                doLogin()
//                            }
//                        }
                        +"Отправить"
                    }

                }
            }
        }
    }


    private fun handleSubmit(event: Event) {
        console.log("Отправленное имя: " + this.state.userName);
        event.preventDefault();
    }

    private fun handleChange(event: Event) {
        val target = event.target as HTMLInputElement
        val userName = target.value

        setState {
            this.userName = userName
        }
    }
}