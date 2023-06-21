package dev.a4j.mastering.data;

import dev.a4j.mastering.data.activerecord.Book;
import dev.a4j.mastering.data.db.BookActiveRecordSupplier;

public class ActiveRecordApp {

    public static void main(String[] args) {
        dev.a4j.mastering.data.activerecord.Book book = BookActiveRecordSupplier.INSTANCE.get();
        book.insist();
        dev.a4j.mastering.data.activerecord.Book entity = Book.findById(book.getTitle())
                .orElseThrow();
        System.out.println("the entity result: " + entity);
    }
}
