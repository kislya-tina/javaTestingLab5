import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteTests {

    String url = "https://petstore.swagger.io/v2/pet/";
    String deletable = "{\"id\": 808, \"name\": \"deleted\"}";

    @Test
    public void deletePetTest() {
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

        given()
                .when()
                .delete(url + "808")
                .then()
                .statusCode(200)
                .extract()
                .response();

        given()
                .when()
                .delete(url + "808")
                .then()
                .statusCode(404)
                .extract()
                .response();
    }
}
