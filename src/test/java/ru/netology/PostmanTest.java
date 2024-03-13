package ru.netology;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanTest {

  @Test
  void shouldPostText() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .body("Postman Test") // отправляемые данные (заголовки и query можно выставлять аналогично)
            // Выполняемые действия
            .when()
            .post("/post")
            // Проверки
            .then()
            .statusCode(200)
            .body("data", equalTo ("Postman Test"));
  }

  @Test
  void shouldPostDate() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .body("13.03.2024") // отправляемые данные (заголовки и query можно выставлять аналогично)
            // Выполняемые действия
            .when()
            .post("/post")
            // Проверки
            .then()
            .statusCode(200)
            .body("data", equalTo ("13.03.2024"));
  }

  @Test
  void shouldPostSymbols() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .contentType("text/plain; charset=UTF-8")
            .body("#$)*") // отправляемые данные (заголовки и query можно выставлять аналогично)
            // Выполняемые действия
            .when()
            .post("/post")
            // Проверки
            .then()
            .statusCode(200)
            .body("data", equalTo ("#$)*"));
  }
  @Test
  void shouldPostCyrillic() {
    // Given - When - Then
    // Предусловия
    given()
            .baseUri("https://postman-echo.com")
            .contentType("text/plain; charset=UTF-8")
            .body("Слова на кириллице") // отправляемые данные (заголовки и query можно выставлять аналогично)
            // Выполняемые действия
            .when()
            .post("/post")
            // Проверки
            .then()
            .statusCode(200)
            .body("data", equalTo ("Слова на кириллице"));
  }
}