package org.ldv.groovium.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {
    @GetMapping("/Groovium/admin")
    fun home(): String {
        return "dashboard"
    }
}