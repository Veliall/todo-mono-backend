package com.todo.javatodo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "role_data", schema = "todolist")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null
    val name: String? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", schema = "todolist", joinColumns = [JoinColumn(name = "role_id")], inverseJoinColumns = [JoinColumn(name = "user_id")])
    val users: Set<User>? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val role = o as Role
        return id == role.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}