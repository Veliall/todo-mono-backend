package com.todo.javatodo.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import java.util.*
import javax.persistence.*

@Entity
@Table(schema = "todolist")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
    val title: String? = null

    @Column(name = "completed_count", updatable = false)
    val completedCount: Long? = null

    @Column(name = "uncompleted_count", updatable = false)
    val uncompletedCount: Long? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val category = o as Category
        return id == category.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}