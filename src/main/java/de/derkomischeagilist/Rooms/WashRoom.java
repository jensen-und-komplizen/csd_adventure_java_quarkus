package de.derkomischeagilist.Rooms;

public class WashRoom extends AbstractRoom {

    public String getDescription() {
        return "You enter a room that looks like a wash room.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "You notice a DoD on the door which leads back to the loo."
                + "</br>"
                + "On the other side of the room you see a door to the hallway.";
    }

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "read dod":
                return "hands washed?" +
                        "</br>" +
                        "paper towels in bin?" +
                        "</br>" +
                        "toilet flushed?";
            default:
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp()
                + "try to 'look around', 'read DoD', or 'use door to hallway', or 'use door to loo'. Might help.";
    }
}
