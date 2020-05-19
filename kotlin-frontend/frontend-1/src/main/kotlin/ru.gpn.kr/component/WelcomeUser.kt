package ru.gpn.kr.component

import kotlinx.css.TextAlign
import kotlinx.css.fontSize
import kotlinx.css.px
import kotlinx.css.textAlign
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv
import styled.styledH1

interface WelcomeUserProps : RProps

class WelcomeUserState : RState {
    var userName: String = ""
}

class WelcomeUser : RComponent<WelcomeUserProps, WelcomeUserState>() {
    init {
        state = WelcomeUserState()
    }

//    override fun componentDidMount() {
//        super.componentDidMount()
//        console.log("didMount")
//    }

    override fun RBuilder.render() {
        styledH1 {
            css {
                textAlign = TextAlign.center
            }
            +"Welcome Page"
        }
        styledDiv {
            css {
                fontSize = 12.px
                textAlign = TextAlign.center
            }

            +"${state.userName} welcome!"
        }
    }
}