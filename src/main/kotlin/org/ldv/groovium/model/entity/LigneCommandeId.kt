package org.ldv.groovium.model.entity

import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class LigneCommandeId (
    var albumId: Int,
    var utilisateurId: Int
): Serializable {
}