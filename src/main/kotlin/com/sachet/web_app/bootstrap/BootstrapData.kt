package com.sachet.web_app.bootstrap

import com.sachet.web_app.model.Author
import com.sachet.web_app.model.Book
import com.sachet.web_app.repositories.AuthorRepository
import com.sachet.web_app.repositories.BookRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BootstrapData(
    val authorRepository: AuthorRepository,
    val bookRepository: BookRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        val eric = Author(fName = "Eric", lName = "Evans")
        val ddd = Book(name = "Domain Driven Design", isbn = "akgue456af122")
        eric.books.add(ddd)
        ddd.authors.add(eric)
        authorRepository.save(eric)
        bookRepository.save(ddd)

        println("BOOTSTRAP________________________________")
        println("Number of books: ${bookRepository.count()}")
    }
}