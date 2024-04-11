import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetTests {

    String url = "https://petstore.swagger.io/v2/pet/";
    String id = "{\"id\":10}";

    @Test
    public void getPetByIDTest() {
        given().
                contentType("application/json").
                body(id).
                when().
                post(url).
                then().
                statusCode(200).
                body("id", CoreMatchers.equalTo(10));

    }

    @Test
    public void getPetByNotFoundIDTest() {
        RestAssured
                .get(url + "707")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void getPetByNotExistIDTest() {
        RestAssured
                .get(url + "e87e88sa99asd")
                .then()
                .assertThat()
                .statusCode(404)
                .and()
                .body("id", CoreMatchers.equalTo(null));
    }
}
