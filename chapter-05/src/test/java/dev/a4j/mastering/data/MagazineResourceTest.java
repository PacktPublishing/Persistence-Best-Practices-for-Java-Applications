package dev.a4j.mastering.data;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class MagazineResourceTest {

    @Test
    public void shouldFindAll() {
        given()
          .when().get("/magazines")
          .then()
             .statusCode(200);
    }

    @Test
    public void shouldInsert() {
        Magazine magazine = new Magazine();
        magazine.edition = 1;
        magazine.name = "Java Magazine";
        magazine.release = 2023;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(magazine)
                .post("/magazines")
                .then()
                .extract().response();
        Magazine magazineResponse = response.getBody().as(Magazine.class);

        assertEquals(magazine.edition, magazineResponse.edition);
        assertEquals(magazine.name, magazineResponse.name);
        assertEquals(magazine.release, magazineResponse.release);
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
                .post("/magazines")
                .then()
                .extract().response();

        ResponseBodyExtractionOptions body = given()
                .when().get("/magazines/release/2019")
                .then()
                .statusCode(200)
                .extract().body();

        List<Magazine> magazines = body.as(new TypeRef<>() {
        });

        Assertions.assertFalse(magazines.isEmpty());

        Assertions.assertTrue(magazines.stream().mapToInt(b -> b.release)
                .allMatch(y -> y == 2019));
    }


}