package de.derkomischeagilist.Rooms;

public class WashRoom extends AbstractRoom {

    public String getDescription() {
        return "You enter a room that looks like a washroom.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "You notice a DoD on the door."
                + "</br>"
                + "On the other side of the room you see another door.";
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
        return "Try to type 'look around', 'read DoD', or 'use door to hallway', or 'use door to loo'." + super.getHelp();
    }
}
