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
        val catGuitares = Categorie(nom = "Guitares électriques")
        val catBatteries = Categorie(nom = "Batteries électriques")
        val catPianos = Categorie(nom = "Pianos électriques")

        categorieDAO.saveAll(listOf(catGuitares , catBatteries, catPianos))

        // === Produits ===

        val produitGuitare = Produit(
            nom = "Guitare",
            description = "Guitare électrique avec câble",
            stock = 65,
            prix = 109.99,
            lienImage = "/img/guitare.png",
            categorie = null
        )

        val produitBatterie = Produit(
            nom = "Batterie",
            description = "Kit complet de batterie électrique avec câbles",
            stock = 15,
            prix = 1249.99,
            lienImage = "img/batterie.png",
            categorie = null
        )


        // === Sauvegarde des articles ===
        produitDAO.saveAll(
            listOf(
                produitGuitare,
                produitBatterie
            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} articles.")
    }
}
