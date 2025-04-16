package de.derkomischeagilist;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdventureTest {

    private Adventure adventure;

    @BeforeEach
    void setUp() {
        adventure = new Adventure();
    }


    @Test
    void currentTimeLooksGood() {
        assertThat("timestamp", TimeService.currentTime("Europe/Berlin"), greaterThan(-1L));
    }

    @Test
    void AdventureStartsOnTheLoo() {
        assertThat(adventure.Begin(), containsString("You wake up on the loo"));
    }

    @Test
    void AdventureProvidesHelpTextAtStartup() {
        String beginText = adventure.Begin();
        assertThat(beginText, containsStringIgnoringCase("enter command"));
        assertThat(beginText, containsStringIgnoringCase("help"));
    }


    @Test
    void LookingAroundInTheLooThenICanSeeMagazines() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("You wake up on the loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("magazines"));
    }

    @Test
    void LookAtTheDoorInTheLoo() {
        //When I look at the door
        String actual = adventure.tell("look at door");
        //Then there is shown, that it is a washroom
        assertThat(actual, CoreMatchers.containsString("washroom"));
    }

    @Test
    void LookingAroundInTheLooThenICanSeeACoin() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see the coin
        assertThat(actual, containsStringIgnoringCase("coin"));
    }


    @Test
    void LookingAroundInTheLooThenIWillFindScrumDeveloperCard() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsString("\"Pathetic Scrum Developer (PSD)\""));
        assertThat(actual, containsStringIgnoringCase("card"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAScrumGuide() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsString("Scrum Guide"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAUsedMickyMouseMagazine() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("used micky mouse magazine"));
    }

    @Test
    void EnteringAnInvalidCommandResultsInHelpfulResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsString("You wake up on the loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, not(containsStringIgnoringCase("invalid command")));
        assertThat(actual, containsStringIgnoringCase("Try to 'look around', 'look at magazines' (better get your gloves), 'look at door', 'look at toilet paper', 'read a joke' or just 'go to washroom' to escape the smell."));
    }

    @Test
    void enteringAnInvalidCommandResultsInFunnyResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String command = "Do something stupid";
        String actual = adventure.tell(command);
        //Then i can see funny response
        assertThat(actual, containsStringIgnoringCase(String.format("Sorry, I don't understand '%s'", command)));
        assertThat(actual, containsStringIgnoringCase("Try to 'look around', 'look at magazines' (better get your gloves), 'look at door', 'look at toilet paper', 'read a joke' or just 'go to washroom' to escape the smell."));
    }


    @Test
    void EnteringHelpInWashroomGivesHintForDod() {
        //given i am in the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;

        //When i ask for help
        String actual = adventure.tell("help");

        //Then i see dod response
        assertThat(actual, containsStringIgnoringCase("read DoD"));


    }

    @Test
    void EnteringAnInvalidCommandStillIncludesPreviousResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("Sorry, I don't understand"));
        assertThat(actual, not(containsStringIgnoringCase("you wake up on the Loo")));
    }

    @Test
    void GoingThroughDoorInTheLooThenICanSeeTheWashRoom() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the washroom
        String actual = adventure.tell("go to washroom");
        //Then i can see the washroom
        assertThat(actual, containsStringIgnoringCase("washroom"));
    }

    @Test
    void LookingAroundInTheWashRoomThenIWillFindDoorAndSink() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the washroom
        adventure.tell("go to washroom");
        //When I look around
        String actual = adventure.tell("look around");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("nasty sink"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenIAmGreetedByMyTeammates() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("go to team office");
        //Then i am greeted by my teammates
        assertThat(actual, containsStringIgnoringCase("Hey, you moron! ;)"));
    }

    @Test
    void StartingInLooShowsDetail() {
        //Show details when beginning in the room
        assertThat(adventure.Begin(), containsStringIgnoringCase("see a pretty dirty"));
    }

    @Test
    void EnteringTeamOfficeShowsDetail() {
        //When I go into the TeamOffice
        String actual = adventure.tell("go to team office");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("many flip charts"));
    }

    @Test
    void EnteringKitchenShowsDetail() {
        //When I go into the Kitchen
        String actual = adventure.tell("go to kitchen");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("It might be the kitchen"));

    }

    @Test
    void EnteringHallwayShowsDetail() {
        //When I go into the Hallway
        String actual = adventure.tell("go to hallway");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("very dark hallway to hell"));

    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenMyTeammatesAreSmartAndSmelly() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("go to team office");
        //Then my teammates are smart
        assertThat(actual, containsStringIgnoringCase("smart"));
        //Then my teammates are smelly
        assertThat(actual, containsStringIgnoringCase("smelly"));
    }

    @Test
    void commandsAreCaseInsensitive() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("Go tO tEaM oFfIcE");
        //Then the command leads me to the team room
        assertThat(actual, not(containsStringIgnoringCase("invalid command")));
    }

    @Test
    void lookAroundShowsDodOnTheDoor() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I look around
        String actual = adventure.tell("look around");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("you notice a  <span class=\"hint\">dod (Definition of Done)</span> on the door"));
    }

    @Test
    void readDodShowsDodDetails() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I read the DoD
        String actual = adventure.tell("read DoD");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("Things to do before you leave the washroom:"));
        assertThat(actual, containsStringIgnoringCase("hands washed"));
        assertThat(actual, containsStringIgnoringCase("paper towels in bin"));
        assertThat(actual, containsStringIgnoringCase("toilet flushed"));
    }

    @Test
    void examineToiletPaperShowsToiletPaperDetails() {
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I examine the toilet paper for the first time
        String actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the first piece is written: \"Scrum Master:"));
        assertThat(actual, containsStringIgnoringCase("There are more pieces on the ground"));
        //When I examine the toilet paper for the second time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("Another one states:"));
        //When I examine the toilet paper for the third time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("Next piece says: \"Product Owner:"));
        //When I examine the toilet paper for the third time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the last piece is written: \"Developers:"));
        assertThat(actual, containsStringIgnoringCase("I remember. I need to find my Scrum team"));
        //When I examine the toilet paper for the fourth time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the first piece is written: \"Scrum Master:"));
    }

    @Test
    void readAJokeOnLooSuccessful(){
        //given I am on the loo
        assertThat(adventure.Begin("Why do we tell actors to 'break a leg?' - Because every play has a cast ;)"), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Why do we tell actors to 'break a leg?' - Because every play has a cast ;)"));
    }

    @Test
    void readAnotherJokeOnLooSuccessful(){
        //given I am on the loo
        assertThat(adventure.Begin("Chuck Norris wins at Planning Poker."), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Chuck Norris wins at Planning Poker."));
    }

    @Test
    void readThirdJokeOnLooSuccessful(){
        //given I am on the loo
        assertThat(adventure.Begin("Why don't scientists trust atoms? Because they make up everything!"), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Why don't scientists trust atoms? Because they make up everything!"));
    }

    @Test
    void readAJokeInWashroomUnsuccesfull(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("There is no joke in this room."));
    }

    @Test
    void commitSuicideInLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void readAJokeOnLooAndCommitSuicide(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Why do we tell actors to 'break a leg?' - Because every play has a cast ;)"));
        actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void moveToHallwayAndCommitSuicide(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("go to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a washroom."));
        actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void moveFromLooToWashroomAndBackToLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("go to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a washroom."));
        actual = adventure.tell("go to loo");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void moveFromLooToWashroomAndTooHallwayAndBackToLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("go to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a washroom."));
        actual = adventure.tell("go to hallway");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("go to loo");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void commandsInCaps(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        // Commands shall work, regardless if written in lower or uppercase
        String actual = adventure.tell("GO tO washrOOm");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a washroom."));
        actual = adventure.tell("GO TO HALLWAY");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("GO TO LOO");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void moveToHallwayAndOpenSpookyDoor(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("go to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a washroom."));
        actual = adventure.tell("go to hallway");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("inspect the spooky door");
        assertThat(actual, containsStringIgnoringCase("coin slot"));
        // TODO we need to fix the test so it asserts that we made it
        actual = adventure.tell("insert coins");
        // assertThat(actual, containsStringIgnoringCase("You made it"));
    }

    @Test
    void useKeypadInHallwayWithNotEnoughCoins(){
        //given I enter the hallway
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.tell("go to hallway");
        // when I use the coin slot
        String actual = adventure.tell("insert coins");
        // i see the description of the coin slot
        assertThat(actual, containsString("Nothing happens"));
    }

    @Test
    void checkStartingRoom() {
        // when
        adventure.Begin();

        // then
        assertThat(adventure.whereAreWe(), equalTo(Location.LOO));
    }

    @Test
    void afterUsingDoorToWashroomWeAreInTheWashroom() {
        // when
        adventure.Begin();
        adventure.tell("go to washroom");

        // then
        assertThat(adventure.whereAreWe(), equalTo(Location.WASHROOM));
    }
}
