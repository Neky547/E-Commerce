package org.ldv.groovium.model.entity

import org.ldv.groovium.model.dao.CategorieDAO
import org.ldv.groovium.model.dao.CommentaireDAO
import org.ldv.groovium.model.dao.ProduitDAO
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val commentaireDAO: CommentaireDAO,
    private val categorieDAO: CategorieDAO,
    private val produitDAO: ProduitDAO
): CommandLineRunner {
    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }
        println("Initialisation des données...")

        // === Catégories ===
        val catGadget = Categorie(nom = "Gadgets")
        val catJouet = Categorie(nom = "Jouets")
        val catMaison = Categorie(nom = "Maison")

        categorieDAO.saveAll(listOf(catGadget, catJouet, catMaison))

        // === Produits ===

        val produitMontre = Produit(
            nom = "Montre connectée",
            description = "Montre connectée avec capteur de fréquence cardiaque et suivi d’activité.",
            stock = 20,
            prix = 79.99,
            lienImage = "https://example.com/images/montre-connectee.jpg",
            categorie = null
        )

        val produitDrone = Produit(
            nom = "Mini drone",
            description = "Drone compact avec caméra HD et contrôle via smartphone.",
            stock = 15,
            prix = 149.99,
            lienImage = "https://example.com/images/mini-drone.jpg",
            categorie = null
        )


        // === Sauvegarde des articles ===
        produitDAO.saveAll(
            listOf(
                produitMontre,
                produitDrone
            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} articles.")
    }
}
