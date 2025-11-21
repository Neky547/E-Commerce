package org.ldv.groovium.controller.clientControllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ClientController {
    @GetMapping("/Groovium/client/profile")
    fun profile(): String{
            return "pageAdmin/produit/index"
    }
}