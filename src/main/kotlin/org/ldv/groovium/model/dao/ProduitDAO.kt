package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.Produit
import org.springframework.data.jpa.repository.JpaRepository

interface ProduitDAO : JpaRepository<Produit, Long> {
}