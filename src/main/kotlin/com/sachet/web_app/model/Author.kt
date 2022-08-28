package com.sachet.web_app.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Author(
    @field:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long ?= null,
    @field:Column(name = "f_name")
    var fName: String ?= null,
    @field:Column(name = "l_name")
    var lName: String ?= null,
    @JsonIgnore
    @ManyToMany(mappedBy = "authors")
    var books: MutableSet<Book> = HashSet()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Author

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Author(id=$id, firstName=$fName, lastName=$lName, books=$books)"
    }


}
