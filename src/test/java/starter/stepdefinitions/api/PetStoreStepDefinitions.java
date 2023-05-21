package starter.stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractions;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import starter.api.petstore.model.Pet;

import static net.serenitybdd.rest.SerenityRest.*;

public class PetStoreStepDefinitions extends UIInteractions {

    public long id;
    @Given("Kitty is available in the pet store")
    public void givenKittyIsAvailableInPetStore() {

        Pet pet = new Pet("Kitty", "available");

        Long newId = given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/pet")
                .body(pet, ObjectMapperType.GSON)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON).post().getBody().as(Pet.class, ObjectMapperType.GSON).getId();
        this.id=newId;
    }

    @When("I ask for a pet using Kitty's ID: {long}")
    public void whenIAskForAPetWithId(Long id) {
        when().get("/" + this.id);
    }

    @Then("I get Kitty as result")
    public void thenISeeKittyAsResult() {
        then().body("name", Matchers.equalTo("Kitty"));
    }
}
