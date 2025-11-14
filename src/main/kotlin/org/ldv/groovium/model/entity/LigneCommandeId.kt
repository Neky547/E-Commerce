package org.ldv.groovium.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class LigneCommandeId (
    var commandeId: Int,
    var produitId: Int
): Serializable {
}