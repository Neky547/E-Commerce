package org.ldv.groovium.model.entity
import jakarta.persistence.*

@Entity
class Commande(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int,

    //Association avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null,

    //Association avec Produit
    @ManyToMany
    @JoinTable(
        name = "commande_produits",
        joinColumns = [JoinColumn(name = "commande_id")],
        inverseJoinColumns = [JoinColumn(name = "produit_id")]
    )
    var produits: MutableList<Produit> = mutableListOf()

) {
    fun afficherDetails(){}

    fun annuler(){}

    fun passerCommande(){}

    fun retirerProduit(){}
}