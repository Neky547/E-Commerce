package org.ldv.groovium.model.entity
import jakarta.persistence.*

@Entity

class Produit (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int,
    var nom: String,
    var prix: Double,
    var categorie: String,

    //Association avec LigneCommande
    @OneToMany(mappedBy = "produit", orphanRemoval = true)
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf()
){
    fun ajouterPanier(){}
}