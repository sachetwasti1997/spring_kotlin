package com.sachet.web_app.model

import org.hibernate.annotations.GeneratorType
import javax.persistence.*

@Entity
data class Book(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long ?= null,
    @field:Column
    var name: String ?= null,
    @field:Column
    var isbn : String ?= null,
    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = [JoinColumn(name = "book_id")],
                inverseJoinColumns = [JoinColumn(name = "author_id")])
    val authors: MutableSet<Author> = HashSet()
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Book(id=$id, name=$name, isbn=$isbn, authors=$authors)"
    }


}