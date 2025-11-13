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

    @ManyToMany
    @JoinTable(
        name = "produit_commandes",
        joinColumns = [JoinColumn(name = "produit_id")],
        inverseJoinColumns = [JoinColumn(name = "commande_id")]
    )
    var commandes: MutableList<Commande> = mutableListOf()
){
    fun ajouterPanier(){}
}