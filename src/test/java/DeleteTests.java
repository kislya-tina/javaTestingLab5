import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteTests {

    String url = "https://petstore.swagger.io/v2/pet/";
    String deletable = "{\"id\": 808, \"name\": \"deleted\"}";


    /**
     * Необходимо соблюдать порядок выполения тестов для их успешного выполениния
     *      1 тест: Размещение животного
     */
    @Test
    public void postPetTest() {
        given()
                .header("Content-Type", "application/json")
                .body(deletable)
                .when()
                .put(url)
                .then()
                .statusCode(200)
                .body("name", equalTo("deleted"))
                .extract()
                .response();
    }

    /**
     * Необходимо соблюдать порядок выполения тестов для их успешного выполениния
     *      2 тест: Успешное удаление животного
     */
    @Test
    public void deleteSuccessTest() {
        given()
                .when()
                .delete(url + "808")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    /**
     * Необходимо соблюдать порядок выполения тестов для их успешного выполениния
     *      3 тест: Неудачное удаление животного
     */
    @Test
    public void deleteFailureTest() {
        given()
                .when()
                .delete(url + "808")
                .then()
                .statusCode(404)
                .extract()
                .response();
    }
}
