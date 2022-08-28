package com.sachet.web_app.repositories

import com.sachet.web_app.model.Author
import com.sachet.web_app.model.Book
import org.springframework.data.repository.CrudRepository

interface AuthorRepository: CrudRepository<Author, Long>

interface BookRepository: CrudRepository<Book, Long>