package org.a4j.mastering.data;

import org.a4j.mastering.data.activerecord.Book;
import org.a4j.mastering.data.db.BookActiveRecordSupplier;

public class ActiveRecordApp {

    public static void main(String[] args) {
        Book book = BookActiveRecordSupplier.INSTANCE.get();
        book.insist();
        Book entity = Book.findById(book.getTitle())
                .orElseThrow();
        System.out.println("the entity result: " + entity);
    }
}
