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
        assert(result.contains("You walk closer to the bin. It is very dirty and smells like an old wet chicken. Inside you see a lot of used paper towels. No one would reach in here."));
    }

    @Test
    void showDifferentContentOfBinWhenLookingAtBinTwice() {
        adventure.tell("use door to washroom");
        String result = adventure.tell("look at bin");
        assert(result.contains("You walk closer to the bin. It is very dirty and smells like an old wet chicken. Inside you see a lot of used paper towels. No one would reach in here."));
        result = adventure.tell("look at bin");
        assert(result.contains("It still smells like an old wet chicken."));
        result = adventure.tell("look at bin");
        assert(result.contains("It still smells like an old wet chicken."));
        result = adventure.tell("look at bin");
        assert(result.contains("Please you don't want to smell it anymore."));

    }

    @Test
    void getDetailedDescription() {
        assertTrue(washRoom.getDetailedDescription().toLowerCase().contains("coin"));
    }
}