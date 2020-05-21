package ru.gpn.kr

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gpn.kr.model.User
import ru.gpn.kr.model.UserCompany
//import java.util.concurrent.atomic.AtomicLong

@RestController
open class UserController {

//    private val idGenerator = AtomicLong()

    @RequestMapping("/getUser")
    fun getUser(): User {
        val userCompany = UserCompany("JSC Browsers")
//        val id = idGenerator.incrementAndGet();

        val user = User(1L, "John", "john@mail.ru", "+7 892 212 33 44", userCompany);
        return user
    }
}
