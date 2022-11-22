package org.a4j.mastering.data.dao;

import org.a4j.mastering.data.Book;
import org.a4j.mastering.data.BookSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMemoryTest {


    private BookDAO dao;

    @BeforeEach
    public void setUp() {
        this.dao = new BookMemory();
    }
    @Test
    @DisplayName("Return an exception when update without data information")
    public void shouldReturnWhenErrorWhenUpdateIsUsed() {
        Book book = BookSupplier.INSTANCE.get();
        dao.update(book);
    }

}