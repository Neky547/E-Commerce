package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.LigneCommande
import org.springframework.data.jpa.repository.JpaRepository

interface LigneCommandeDAO : JpaRepository<LigneCommande, Long> {
}