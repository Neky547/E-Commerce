package org.ldv.groovium.model.entity
import java.time.LocalDate

import jakarta.persistence.*

@Entity
class Commentaire(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)

    var id: Int,
    var texte: String,
    var datePublication: LocalDate,

    //Association avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateurs: Utilisateur? = null
) {}