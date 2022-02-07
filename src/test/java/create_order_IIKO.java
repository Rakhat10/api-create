import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class create_order_IIKO {
    // create new order in IIKO-transport mc

   // @BeforeAll
   // static void setUp() {RestAssured.baseURI = "http://iiko-transport.chocodev.kz/iiko-transport/";}


    // сначала надо чекнуть состояние микросервиса базовым методом
    @Test
    void HelloWorldCheck() {
        given()
                .when()
                .get("http://iiko-transport.chocodev.kz/iiko-transport")
                .then()
                .statusCode(200);

    }

    //Получение организации
    @Test
    void getListPlace() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .header("x-user", "12785496")
                .get("http://iiko-transport.chocodev.kz/iiko-transport/v1/credentials")
                .then()
                .statusCode(200)
                .body("status", Matchers.equalToObject("success"));

    }

    // получить стоп-лист заведения
    @Test
    void stopList() {
        given()
                .when()
                .get("http://iiko-transport.chocodev.kz/iiko-transport/v1/pos/6344/stop-list")
                .then()
                .statusCode(200)
                .body("message", Matchers.equalToObject("Стоп-лист заведения"));
    }
    //получить меню заведения по terminal_id
    @Test
    void menuOfPlace() {
        given()
                .when()
                .get("http://iiko-transport.chocodev.kz/iiko-transport/v1/pos/6344/menu")
                .then()
                .statusCode(200)
                .body("message", Matchers.equalToObject("Запрос успешен"));
    }
}

