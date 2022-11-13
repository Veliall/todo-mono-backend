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
class Stat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    val id: Long? = null

    @Column(name = "completed_total", updatable = false) //триггер в БД
    val completedTotal: Long? = null

    @Column(name = "uncompleted_total", updatable = false) //триггер в БД
    val uncompletedTotal: Long? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val stat = o as Stat
        return id == stat.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}