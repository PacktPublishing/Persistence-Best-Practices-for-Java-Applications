package dev.a4j.mastering.data;

import dev.a4j.mastering.data.dao.BookMemory;
import dev.a4j.mastering.data.db.BookSupplier;
import dev.a4j.mastering.data.repository.Library;
import dev.a4j.mastering.data.repository.LibraryMemory;

import java.util.Optional;

public class RepositoryApp {

    public static void main(String[] args) {
        Book book = BookSupplier.INSTANCE.get();
        Library library = new LibraryMemory(new BookMemory());
        library.save(book);
        Optional<Book> entity = library.findByTitle(book.getTitle());
        System.out.println("the entity result: " + entity);
    }
}
