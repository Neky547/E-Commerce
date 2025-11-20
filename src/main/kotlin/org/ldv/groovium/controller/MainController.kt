package org.ldv.groovium.controller

import org.apache.tomcat.util.net.openssl.ciphers.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController {
    @GetMapping("/Groovium")
    fun home():String{
        return "index"
    }

    @GetMapping("/Accueil")
    fun apropos():String{
        return "pagesVisiteur/a-propos"
    }

    @GetMapping("/Contact")
    fun contact():String{
        return "pagesVisiteur/contact"
    }

    @GetMapping("/Inscription")
    fun inscription():String{
        return "pagesVisiteur/inscription"
    }

    @GetMapping("/Produits")
    fun produits():String{
        return "pagesVisiteur/produits"
    }

    @GetMapping("/RGPD")
    fun rgpd():String{
        return "pagesVisiteur/rgpd"
    }

    //LOGIN
    @GetMapping("/Groovium/login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }

    //PROFIL
    @GetMapping("/e-kommerce/profil")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/e-kommerce/admin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pagesClient/profile"
    }


}