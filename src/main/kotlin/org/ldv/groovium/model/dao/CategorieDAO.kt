package org.ldv.groovium.model.dao

import org.ldv.groovium.model.entity.Categorie
import org.springframework.data.jpa.repository.JpaRepository

interface CategorieDAO : JpaRepository<Categorie, Long>{
}