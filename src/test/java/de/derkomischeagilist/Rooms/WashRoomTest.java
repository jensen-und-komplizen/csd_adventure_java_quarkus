package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Adventure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WashRoomTest {


   Adventure adventure = new Adventure();


    @Test
    void showPaperBinInLookAroundInWashroom() {
        adventure.tell("use door to washroom");
        String result = adventure.tell("look around");
        assert(result.contains("There is a bin next to the sink."));
    }

    @Test
    void showContentOfBinWhenLookingAtBin() {
        adventure.tell("use door to washroom");
        String result = adventure.tell("look at bin");
        assert(result.contains("There are used papertowels in here."));
    }
}
