package org.ldv.groovium.model.entity

import jakarta.persistence.*

@Entity
class Categorie(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int,
    var nom: String,

    //Association avec Produit
    @OneToMany(mappedBy = "categorie",cascade = [CascadeType.ALL], orphanRemoval = true)
    var produits: MutableList<Produit> = mutableListOf(),
) {}