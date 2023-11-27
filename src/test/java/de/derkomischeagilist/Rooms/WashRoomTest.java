package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Adventure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WashRoomTest {
    Adventure adventure = new Adventure();
    WashRoom washRoom = new WashRoom();

    @Test
    void showPaperBinInLookAroundInWashroom() {
        adventure.tell("use door to washroom");
        String result = adventure.tell("look around");
        assert(result.contains("There is a <span class=\"hint\">bin</span> next to the sink."));
    }
    @Test
    void showContentOfBinWhenLookingAtBin() {
        adventure.tell("use door to washroom");
        String result = adventure.tell("look at bin");
        assert(result.contains("You walk closer to the bin. It is very dirty and smells like a wet dog. Inside you see a lot of used paper towels. No one would reach in here."));
    }

    @Test
    void getDetailedDescription() {
        assertTrue(washRoom.getDetailedDescription().toLowerCase().contains("coin"));
    }
}