package org.ldv.groovium.Service

import org.ldv.groovium.model.dao.CategorieDAO
import org.ldv.groovium.model.dao.CommentaireDAO
import org.ldv.groovium.model.dao.ProduitDAO
import org.ldv.groovium.model.dao.RoleDAO
import org.ldv.groovium.model.dao.UtilisateurDAO
import org.ldv.groovium.model.entity.Categorie
import org.ldv.groovium.model.entity.Produit
import org.ldv.groovium.model.entity.Role
import org.ldv.groovium.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    val commentaireDAO: CommentaireDAO,
    val categorieDAO: CategorieDAO,
    val produitDAO: ProduitDAO,
    val roleDAO: RoleDAO,
    val utilisateurDAO: UtilisateurDAO,
    val passwordEncoder: PasswordEncoder,

): CommandLineRunner {
    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (categorieDAO.count() > 0 || produitDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }
        println("Initialisation des données...")

        // ROLE
        val roleAdmin: Role = Role(
            nom = "ADMIN"
        )
        val roleClient: Role = Role(
            nom = "CLIENT"
        )
        roleDAO.saveAll(listOf(roleAdmin, roleClient))

        val admin = Utilisateur(
            id = null,
            nom = "Super",
            prenom = "Admin",
            email = "admin@admin.com",
            mdp = passwordEncoder.encode("admin123"), // mot de passe hashé
            role = roleAdmin
        )

        val client = Utilisateur(
            id = null,
            nom = "Jean",
            prenom = "Client",
            email = "client@client.com",
            mdp = passwordEncoder.encode("client123"), // mot de passe hashé
            role = roleClient
        )
        utilisateurDAO.saveAll(listOf(admin, client))


        // === Catégories ===
        val catGuitares = Categorie(nom = "Guitares électriques")
        val catBatteries = Categorie(nom = "Batteries électriques")
        val catPianos = Categorie(nom = "Pianos électriques")

        categorieDAO.saveAll(listOf(catGuitares , catBatteries, catPianos))

        // === Produits ===

        val produitGuitare = Produit(
            nom = "Guitare AK47",
            description = "Guitare électrique avec câble",
            stock = 65,
            prix = 109.99,
            lienImage = "/img/guitareAK47.jpg",
            categorie = catGuitares,
        )

        val produitBatterie = Produit(
            nom = "Batterie Thunderstrike X900",
            description = "Batterie électrique professionnelle noir & or avec module numérique",
            stock = 10,
            prix = 1799.99,
            lienImage = "/img/batterieP90.jpg",
            categorie = catBatteries
        )

        val produitGuitareM4 = Produit(
            nom = "Guitare M4 Shadow",
            description = "Guitare électrique premium en finition noir et doré",
            stock = 42,
            prix = 189.99,
            lienImage = "/img/guitareM4Shadow.jpg",
            categorie = catGuitares
        )

        val produitPianoEclipse = Produit(
            nom = "Piano Eclipse 88",
            description = "Piano électrique 88 touches full black avec détails dorés",
            stock = 23,
            prix = 899.99,
            lienImage = "/img/pianoEclipse88.jpg",
            categorie = catPianos
        )



        // === Sauvegarde des articles ===
        produitDAO.saveAll(
            listOf(
                produitGuitare,
                produitBatterie,
                produitGuitareM4,
                produitPianoEclipse
            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${produitDAO.count()} articles.")
    }
}