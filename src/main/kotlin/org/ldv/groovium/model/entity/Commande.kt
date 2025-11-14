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

    //Association avec Ligne commande
    @OneToMany(mappedBy = "commande", orphanRemoval = true)
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf()

) {
    fun afficherDetails(){}

    fun annuler(){}

    fun passerCommande(){}

    fun retirerProduit(){}
}