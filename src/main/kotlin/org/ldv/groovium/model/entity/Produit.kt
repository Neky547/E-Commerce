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

    //Association avec LigneCommande
    @OneToMany(mappedBy = "produit", orphanRemoval = true)
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf(),

    //Association avec catégorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    var categorie: Categorie? = null
){
    fun ajouterPanier(){}
}