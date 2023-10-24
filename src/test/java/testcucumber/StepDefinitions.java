package testcucumber;

import de.derkomischeagilist.Adventure;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepDefinitions {

    private Adventure adventure;
    private String lastResponse;

    private void assertThatTheLooIsTheInitialRoom() {
        assertThat(lastResponse, containsStringIgnoringCase("on the loo"));
    }

    @Given("I am playing the game")
    public void i_am_playing_the_game() {
        adventure = new Adventure();
        lastResponse = adventure.Begin();

        assertThat(lastResponse, is(not(emptyString())));
    }

    @Given("I am on the loo")
    public void i_am_on_the_loo() {
        i_am_playing_the_game();
        assertThatTheLooIsTheInitialRoom();
    }

    @Given("I am in the washroom")
    public void i_am_in_the_washroom() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to washroom");

        assertThat(lastResponse, containsStringIgnoringCase("looks like a washroom"));
    }
    @When("I say {string}")
    public void i_say(String string) {
        lastResponse = adventure.tell(string);
    }

    @When("I ask for help")
    public void i_ask_for_help() {
        lastResponse = adventure.tell("help");
    }

    @Then("I see {string}")
    public void i_see(String string) {
        assertThat(lastResponse, containsStringIgnoringCase(string));
    }

    @When("I use the door to the hallway")
    public void i_use_the_door_to_the_hallway() {
        lastResponse = adventure.tell("use door to hallway");
    }

    @Then("I am now in the hallway")
    public void i_am_now_in_the_hallway() {
        assertThat(lastResponse, containsStringIgnoringCase("welcome to the hallway"));
    }

    @Given("I am in the hallway")
    public void i_am_in_the_hallway() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to hallway");

        i_am_now_in_the_hallway();
    }

    @When("I use the door to the team office")
    public void i_use_the_door_to_the_team_office() {
        lastResponse = adventure.tell("use door to team office");
    }

    @Given("I am in the team office")
    public void i_am_in_the_team_office() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to team office");

        i_am_now_in_the_team_office();
    }

    @Then("I am now in the team office")
    public void i_am_now_in_the_team_office() {
        assertThat(lastResponse, containsStringIgnoringCase("stinky room"));
    }

    @Given("we are in the kitchen")
    public void we_are_in_the_kitchen() {
        i_am_playing_the_game();

        lastResponse = adventure.tell("use door to kitchen");

        we_am_now_in_the_kitchen();
    }

    @When("I look around")
    public void i_look_around() {
        lastResponse = adventure.tell("look around");
    }

    @Then("we am now in the kitchen")
    public void we_am_now_in_the_kitchen() {
        assertThat(lastResponse, containsStringIgnoringCase("kitchen"));
    }

    @When("we look at the colleague")
    public void we_look_at_the_colleague() {
        lastResponse = adventure.tell("look at colleague");
    }

    @Then("he will greet us with {string}")
    public void he_will_greet_us_with(String greeting) {
        assertThat(lastResponse, containsStringIgnoringCase(greeting));
    }

    @Then("I can see the coffee maker")
    public void i_can_see_the_coffee_maker() {
        assertThat(lastResponse, containsStringIgnoringCase("a coffee maker"));
    }

    @Given("I added all necessary components to the coffee machine")
    public void i_added_all_necessary_components_to_the_coffee_machine() {
        adventure.tell("add beans");
        adventure.tell("add water");
        adventure.tell("connect power");
        adventure.tell("put in cup");
    }

    @Then("I see hints for interactable objects")
    public void iSeeHintsForInteractableObjects() {
        assertThat(lastResponse, containsStringIgnoringCase("<span class=\"hint\">"));
    }
}
