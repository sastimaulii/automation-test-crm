package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserSteps {

    Response response;

    @Given("User set GET endpoint")
    public void setEndpoint() {
        baseURI = "https://dummyapi.io/data/v1/user/60d0fe4f5311236168a109ca";
    }

    @Given("User set invalid GET endpoint")
    public void setInvalidEndpoint() {
        baseURI = "https://dummyapi.io/data/v1/user/invalid";
    }

    @When("User send GET request")
    public void sendRequest() {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get();
    }

    @Then("Response status should be 200")
    public void validate200() {
        response.then().statusCode(200);
    }

    @Then("Response status should be 404")
    public void validate404() {
        response.then().statusCode(404);
    }
}