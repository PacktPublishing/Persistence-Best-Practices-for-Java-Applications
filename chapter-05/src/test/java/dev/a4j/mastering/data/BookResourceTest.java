package dev.a4j.mastering.data;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldFindAll() {
        given()
          .when().get("/library")
          .then()
             .statusCode(200);
    }

    @Test
    public void shouldInsert() {
        Book book = new Book();
        book.edition = 1;
        book.name = "Effective Java";
        book.release = 2009;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(book)
                .post("/library")
                .then()
                .extract().response();
        Book bookResponse = response.getBody().as(Book.class);

        assertEquals(book.edition, bookResponse.edition);
        assertEquals(book.name, bookResponse.name);
        assertEquals(book.release, bookResponse.release);
    }

    @Test
    public void shouldFinbbyYear() {
        Book book = new Book();
        book.edition = 2;
        book.name = "Effective Java";
        book.release = 2019;

        given()
                .contentType(ContentType.JSON)
                .body(book)
                .post("/library")
                .then()
                .extract().response();

        ResponseBodyExtractionOptions body = given()
                .when().get("/library/release/2019")
                .then()
                .statusCode(200)
                .extract().body();

        List<Book> books = body.as(new TypeRef<List<Book>>() {
        });

        Assertions.assertFalse(books.isEmpty());

        Assertions.assertTrue(books.stream().mapToInt(b -> b.release)
                .allMatch(y -> y == 2019));
    }


}