package org.ldv.groovium.controller.adminControllers

import org.ldv.groovium.model.dao.CategorieDAO
import org.ldv.groovium.model.dao.ProduitDAO
import org.ldv.groovium.model.entity.Produit
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class AdminProduitController (val produitDAO: ProduitDAO, val categorieDAO: CategorieDAO){
    @GetMapping("/Groovium/admin/produit")
    fun index(model: Model): String{
        model.addAttribute("produits", produitDAO.findAll())
        return "pageAdmin/produit/index"
    }
    //Méthode d'affichage des détails
    @GetMapping("/Groovium/admin/produit/{id}")
    fun show(@PathVariable id:Int, model:Model):String{
        val unProduit = produitDAO.findById(id).orElseThrow()
        model.addAttribute("produit", unProduit)
        return "pageAdmin/produit/show"
    }

    //Méthode de création de produit
    @GetMapping("/Groovium/admin/produit/creer")
    fun create(model: Model):String{
        var nouveauProduit = Produit(nom = "", description = "", stock = 1, prix = 1.0, lienImage = "")
        var categories = categorieDAO.findAll()
        model.addAttribute("categories", categories)
        model.addAttribute("produit", nouveauProduit)
        return "pageAdmin/produit/create"
    }
}