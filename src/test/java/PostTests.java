import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostTests {

    String pet = "{\"id\": 16, \"name\": \"brabus\"}";
    String url = "https://petstore.swagger.io/v2/pet/";

    @Test
    public void postPetTest() {
        given()
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .put(url)
                .then()
                .statusCode(200)
                .body("name", equalTo("brabus"))
                .extract()
                .response();
    }


}
