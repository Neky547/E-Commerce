package org.ldv.groovium.model.entity
import jakarta.persistence.*

@Entity

class Produit (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int? = null,
    var nom: String,
    var description: String,
    var stock: Int,
    var prix: Double,
    var lienImage: String,


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