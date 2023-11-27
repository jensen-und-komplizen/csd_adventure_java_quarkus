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
}