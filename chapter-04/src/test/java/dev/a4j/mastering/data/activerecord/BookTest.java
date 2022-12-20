package dev.a4j.mastering.data.activerecord;

import dev.a4j.mastering.data.db.BookActiveRecordSupplier;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {


    @Test
    public void shouldInsert() {
        Book book = BookActiveRecordSupplier.INSTANCE.get();
        book.insist();
        Book model = Book.findById(book.getId()).orElseThrow();
        Assertions.assertNotNull(model);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(book.getId()).isEqualTo(model.getId());
            softly.assertThat(book.getAuthor()).isEqualTo(model.getAuthor());
            softly.assertThat(book.getGenre()).isEqualTo(model.getGenre());
            softly.assertThat(book.getPublisher()).isEqualTo(model.getPublisher());
        });
    }

}