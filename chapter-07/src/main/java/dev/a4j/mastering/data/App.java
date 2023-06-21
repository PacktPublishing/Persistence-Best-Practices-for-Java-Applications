package dev.a4j.mastering.data;

import dev.a4j.mastering.data.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import java.util.concurrent.ThreadLocalRandom;

import static dev.a4j.mastering.data.Tables.BOOK;

public class App {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            DSLContext context = container.select(DSLContext.class).get();
            BookRecord record = context.newRecord(BOOK);
            int randomId = random.nextInt(0, 100);
            record.setId(randomId);
            record.setRelease(2022);
            record.setAuthor("Otavio Santana");
            record.setTitle("Apache Cassandra Horizontal scalability for Java applications");
            record.store();

            Result<Record> books = context.select()
                    .from(BOOK)
                    .orderBy(BOOK.TITLE)
                    .fetch();

            books.forEach(book -> {
                var id = book.getValue(BOOK.ID);
                var author = book.getValue(BOOK.AUTHOR);
                var title = book.getValue(BOOK.TITLE);
                var release = book.getValue(BOOK.RELEASE);

                System.out.printf("Book %s by %s has id: %d and release: %d%n",
                        title, author, id, release);
            });

            context.update(BOOK)
                    .set(BOOK.TITLE, "Cassandra Horizontal scalability for Java applications")
                    .where(BOOK.ID.eq(randomId))
                    .execute();

            context.delete(BOOK)
                    .where(BOOK.ID.eq(randomId))
                    .execute();
        }
    }
}
