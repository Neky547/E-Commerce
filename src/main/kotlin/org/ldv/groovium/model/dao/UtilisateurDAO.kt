package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository

interface UtilisateurDAO : JpaRepository<Utilisateur, Long> {

}
