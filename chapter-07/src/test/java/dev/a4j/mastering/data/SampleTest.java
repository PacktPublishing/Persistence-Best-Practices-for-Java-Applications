package dev.a4j.mastering.data;

import dev.a4j.mastering.data.tables.records.BookRecord;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectSeekStep1;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static dev.a4j.mastering.data.Tables.BOOK;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.using;
public class SampleTest {


    @Test
    public void run() throws SQLException {
        Connection connection = DriverManager.getConnection(                      "jdbc:h2:~/jakarta-db", "sa", "");
        DSLContext context = using(connection, SQLDialect.H2);
//        BookRecord record = context.newRecord(BOOK);
//        record.store();
        Result<Record2<String, String>> fetch = context.
                select(BOOK.TITLE, BOOK.AUTHOR)
                .from(BOOK)
                .orderBy(BOOK.RELEASE).fetch();
        System.out.println(fetch);


    }
}
