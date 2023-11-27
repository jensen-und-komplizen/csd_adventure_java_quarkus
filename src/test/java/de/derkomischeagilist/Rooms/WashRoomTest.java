package de.derkomischeagilist.Rooms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WashRoomTest {
    WashRoom washRoom = new WashRoom();

    @Test
    void getDetailedDescription() {
        assertTrue(washRoom.getDetailedDescription().toLowerCase().contains("coin"));
    }
}