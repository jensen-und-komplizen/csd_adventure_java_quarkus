package de.derkomischeagilist;

import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GameResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .when()
        .get("/game")
        .then()
        .statusCode(200)
        .body(containsString("You wake up on the loo"));
  }

  @Test
  public void testNoHelpDescription() {
    given()
        .when()
        .get("/game")
        .then()
        .statusCode(200)
        .body(CoreMatchers.not(containsString("help")));
  }
}
