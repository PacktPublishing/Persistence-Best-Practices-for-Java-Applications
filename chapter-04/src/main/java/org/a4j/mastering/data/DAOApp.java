package org.a4j.mastering.data;

import org.a4j.mastering.data.dao.BookDAO;
import org.a4j.mastering.data.dao.BookMemory;
import org.a4j.mastering.data.db.BookSupplier;

public class DAOApp {

    public static void main(String[] args) {
        Book book = BookSupplier.INSTANCE.get();
        BookDAO dao = new BookMemory();
        dao.insert(book);
        Book entity = dao.findById(book.getTitle())
                .orElseThrow();
        System.out.println("the entity result: " + entity);
    }
}
