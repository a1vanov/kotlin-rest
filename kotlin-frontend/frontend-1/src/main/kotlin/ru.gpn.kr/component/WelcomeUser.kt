package ru.gpn.kr.component

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.css.TextAlign
import kotlinx.css.fontSize
import kotlinx.css.px
import kotlinx.css.textAlign
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.setState
import ru.gpn.kr.service.UserService
import styled.css
import styled.styledDiv
import styled.styledH1

interface WelcomeUserProps : RProps {
    var coroutineScope: CoroutineScope
}

class WelcomeUserState : RState {
    var userName: String = ""
}

class WelcomeUser : RComponent<WelcomeUserProps, WelcomeUserState>() {
    init {
        state = WelcomeUserState()
    }

    override fun componentDidMount() {
        props.coroutineScope.launch {
            val userService = UserService()
            val u = async { userService.getUser() }.await()

            setState {
                this.userName = u.name
            }
        }
        console.log("componentDidMount")
    }

    override fun RBuilder.render() {
        styledH1 {
            css {
                textAlign = TextAlign.center
            }
            +"Welcome Page"
        }
        styledDiv {
            css {
                fontSize = 14.px
                textAlign = TextAlign.center
            }

            +"${state.userName} welcome!"
        }
    }
}