package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.Commentaire
import org.springframework.data.jpa.repository.JpaRepository

interface CommentaireDAO : JpaRepository<Commentaire, Long> {
}