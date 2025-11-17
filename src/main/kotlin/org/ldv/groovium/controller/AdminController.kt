package org.ldv.groovium.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminController {
    @GetMapping("/Groovium/admin")
    fun home(): String {
        return "pageAdmin/dashboard"
    }
}