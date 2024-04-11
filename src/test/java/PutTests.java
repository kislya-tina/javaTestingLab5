import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PutTests {

    String url = "https://petstore.swagger.io/v2/pet/";
    String id = "{\"id\":28}";

    @Test
    public void putPetTest() {
        given().
                contentType("application/json").
                body(id).
                when().
                put(url).
                then().
                statusCode(200).
                body("id", equalTo(28));
    }
}
