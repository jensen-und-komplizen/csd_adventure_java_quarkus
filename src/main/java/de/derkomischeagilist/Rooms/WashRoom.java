package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Items.Bin;

public class WashRoom extends AbstractRoom {

    private final Bin bin;

    public WashRoom() {
        this.bin = new Bin();
    }

    public String getDescription() {
        return "You enter a room that looks like a washroom.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "There is a <span class=\"hint\">bin</span> next to the sink."
                + "<br/>"
                + "You notice a  <span class=\"hint\">DoD</span> on the door."
                + "</br>"
                + "There is a door to the <span class=\"hint\">loo</span>."
                + "</br>"
                + "On the other side of the room you see another door."
                + "</br>"
                + "On the floor you see a coin.";
    }

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "read dod":
                return "hands washed?" +
                        "</br>" +
                        "paper towels in bin?" +
                        "</br>" +
                        "toilet flushed?";
            case "look at bin":
                return bin.getDescription();
            default:
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around', 'read DoD', or 'use door to hallway', or 'use door to loo'."
                + super.getHelp();
    }
}
