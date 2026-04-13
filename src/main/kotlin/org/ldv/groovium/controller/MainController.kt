package org.ldv.groovium.controller

import org.ldv.groovium.model.dao.ProduitDAO
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class MainController(private val produitDAO: ProduitDAO) {
    @GetMapping("/Groovium")
    fun home():String{
        return "index"
    }

    @GetMapping("Groovium/Accueil")
    fun apropos():String{
        return "pagesVisiteur/a-propos"
    }

    @GetMapping("Groovium/Contact")
    fun contact():String{
        return "pagesVisiteur/contact"
    }

    @GetMapping("Groovium/Inscription")
    fun inscription():String{
        return "pagesVisiteur/inscription"
    }

    @GetMapping("/Groovium/Produits")
    fun listeProduits(model: Model): String {
        model.addAttribute("produits", produitDAO.findAll())
        return "pagesVisiteur/produits"

    }

    @GetMapping("Groovium/RGPD")
    fun rgpd():String{
        return "pagesVisiteur/rgpd"
    }

    //LOGIN
    @GetMapping("/Groovium/Login")
    fun login(@RequestParam error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }


    //PROFIL
    @GetMapping("/Groovium/Profile")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/Groovium/admin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pageClient/profile"
    }

}