package de.derkomischeagilist.Rooms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LooTest {
    Loo loo = new Loo();
    String lookAtDoor = "look at door";

    @Test
    void handleCommandHandelsLookAtDoor() {
        String result = loo.handleCommand(lookAtDoor);
        assertTrue(result.toLowerCase().contains("washroom"));
    }

    @Test
    void getHelpContainsLookAtDoor() {
        String result = loo.getHelp();
        assertTrue(result.toLowerCase().contains(lookAtDoor));
    }

    @Test
    void testLookAtMagazineHighlighting() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("look at magazines").contains("<span class=\"hint\">Scrum Guide 2009</span>"));
    }

    @Test
    void testReadScrumGuide2009() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("read scrum guide 2009").contains("better Scrum Developer"));
    }
    @Test
    void testReadScrumGuide() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("read scrum guide").contains("better Scrum Developer"));
    }

    @Test
    void testPickUpCoin() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("pick up coin").contains("You picked up the coin"));
    }

    @Test
    void testPickUpCoinOnlyOnce() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("pick up coin").contains("You picked up the coin"));
        assertTrue(loo.handleCommand("pick up coin").contains("You already picked up the coin"));

    }

    @Test
    void testScrumMasterFirstTime() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("talk to scrum master").contains("I am the Scrum Master and I have a riddle for you"));
    }

    @Test
    void testScrumMasterAlreadyAnsweredCorrectly() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("talk to scrum master").contains("I am the Scrum Master and I have a riddle for you"));
        loo.handleCommand("definition of done");
        assertTrue(loo.handleCommand("talk to scrum master").contains("You cannot learn anymore from me!"));
    }
    @Test
    void testScrumMasterAlreadyAnsweredWrong() {
        Loo loo = new Loo();
        assertTrue(loo.handleCommand("talk to scrum master").contains("I am the Scrum Master and I have a riddle for you"));
        assertTrue(loo.handleCommand("ignore").contains("You ignore the Scrum Master. He looks disappointed."));
    }
}
