import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonFile {
    @Test
    void CreateOrder()
    {
        // Creating file instance
        File JsonData = new File("src/test/resources/Data/jsondata.json");
        given()
                .contentType(ContentType.JSON)
                .body(JsonData)
                .when()
                .post("https://webhook.site/3f0e7317-1a2f-4a9a-980d-8d24961877a4")
                .then()
                .statusCode(200);

    }
}
