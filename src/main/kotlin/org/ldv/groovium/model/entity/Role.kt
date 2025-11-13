package org.ldv.groovium.model.entity
import jakarta.persistence.*

@Entity

class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int,
    var nom: String,

    //Association avec Utilisateur
    @OneToMany(mappedBy = "role",cascade = [CascadeType.ALL], orphanRemoval = true)
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()
) {}