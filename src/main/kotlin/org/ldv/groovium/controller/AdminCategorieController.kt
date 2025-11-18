package org.ldv.groovium.controller

import org.ldv.groovium.model.dao.CategorieDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminCategorieController(val categorieDAO: CategorieDAO) {

    @GetMapping("/Groovium/admin/categorie")
    fun index(model: Model): String {
        //On récupère les valeurs de chaque catégorie avec l'attribut "categories"
        model.addAttribute("categories",categorieDAO.findAll())
        return "pageAdmin/categorie/index"
    }

}