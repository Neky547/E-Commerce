package org.ldv.groovium.model.dao
import org.ldv.groovium.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {
}