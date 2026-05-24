package api.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserSteps {

    Response response;

    @Given("User set GET endpoint")
    public void setEndpoint() {
        baseURI = "https://dummyapi.io/data/v1";
    }

    @When("User send GET request")
    public void sendRequest() {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("/user"); // for 200

        System.out.println("STATUS: " + response.getStatusCode());
        response.then().log().all();
    }

    @When("User send invalid GET request")
    public void sendInvalidRequest() {
        response = given()
                .header("app-id", "63a804408eb0cb069b57e43a")
                .when()
                .get("/user/123-invalid"); // for invalid

        System.out.println("INVALID STATUS: " + response.getStatusCode());
        response.then().log().all();
    }

    @Then("Response status should be 200")
    public void validate200() {
        int status = response.getStatusCode();
        System.out.println("EXPECT 200, ACTUAL: " + status);

        if (status != 200) {
            throw new AssertionError("Expected 200 but got " + status);
        }
    }

    @Then("Response status should be 404")
    public void validate404() {
        int status = response.getStatusCode();
        System.out.println("EXPECT 404, ACTUAL: " + status);

        if (status != 404 && status != 400) {
            throw new AssertionError("Expected 404/400 but got " + status);
        }
    }
}