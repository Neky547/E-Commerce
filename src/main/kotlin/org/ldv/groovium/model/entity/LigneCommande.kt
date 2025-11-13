package org.ldv.groovium.model.entity

import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity

//Classe associative
@Entity
class LigneCommande(
    @EmbeddedId
    var quantite: Int,

    //A MODIFIER
    MapsId("albumId")
    @ManyToOne
    @JoinColumn(name = "album_id")
    var album: Album? = null,


    @MapsId("utilisateurId")
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null
) {}