package org.ldv.groovium.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId

//Classe associative
@Entity
class LigneCommande(
    @EmbeddedId
    var quantite: Int,
    var ligneCommandeId: LigneCommandeId? = null,

    //Association avec commande et produit
    @MapsId("commandeId")
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null,


    @MapsId("produitId")
    @ManyToOne
    @JoinColumn(name = "produit_id")
    var produit: Produit? = null
) {}