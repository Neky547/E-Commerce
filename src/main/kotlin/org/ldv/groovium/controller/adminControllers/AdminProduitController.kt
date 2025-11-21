package org.ldv.groovium.controller.adminControllers

import org.ldv.groovium.model.dao.ProduitDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AdminProduitController (val produitDAO: ProduitDAO){
    @GetMapping("/Groovium/admin/produit")
    fun index(model: Model): String{
        model.addAttribute("produits", produitDAO.findAll())
        return "pageAdmin/produit/index"
    }
}