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

}
