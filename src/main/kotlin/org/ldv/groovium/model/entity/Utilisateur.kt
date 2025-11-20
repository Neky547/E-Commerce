package org.ldv.groovium.model.entity
import jakarta.persistence.*

@Entity

class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int? = null,
    var nom: String,
    var prenom: String,
    var email: String,
    var mdp: String,

    //Association avec Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null,

    //Association avec Commentaire
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Association avec commande
    @OneToMany(mappedBy = "utilisateur",cascade = [CascadeType.ALL], orphanRemoval = true)
    var commandes: MutableList<Commande> = mutableListOf()

) {}