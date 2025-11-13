package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.Commande
import org.springframework.data.jpa.repository.JpaRepository

interface CommandeDAO : JpaRepository<Commande, Long> {
}