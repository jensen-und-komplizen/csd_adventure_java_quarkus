package de.derkomischeagilist.Rooms;

import de.derkomischeagilist.Inventory;
import de.derkomischeagilist.Items.Bin;
import de.derkomischeagilist.Items.Door;

public class WashRoom extends AbstractRoom {

    private final Bin bin;
    private boolean coinPickedUp;

    private final Door door;

    public WashRoom() {
        this.bin = new Bin();
        this.coinPickedUp = false;
        this.door = new Door();
    }

    public String getDescription() {
        return "You enter a room that looks like a washroom.";
    }

    public String getDetailedDescription() {
        return "You see an incredibly nasty sink with an undefinable substance in it. Ew!"
                + "<br/>"
                + "There is a <span class=\"hint\">bin</span> next to the sink."
                + "<br/>"
                + "You notice a  <span class=\"hint\">DoD (Definition of Done)</span> on the door."
                + "</br>"
                + "There is a door to the <span class=\"hint\">loo</span>."
                + "</br>"
                + "On the other side of the room you see another <span class=\"hint\">door</span>."
                + "</br>"
                + (coinPickedUp ? "" : "On the floor you see a <span class=\"hint\">coin</span>.");
    }

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "read dod":
                return "Things to do before you leave the washroom:</br>" +
                        "Hands washed?" +
                        "</br>" +
                        "Paper towels in bin?" +
                        "</br>" +
                        "Toilet flushed?";
            case "look at bin":
                return bin.getDescription();
            case "pick up coin":
                if (coinPickedUp) {
                    return "You already picked up the coin.";
                }
                Inventory.addCoin();
                coinPickedUp = true;
                return "You picked up the coin.";
            case "look at door":
                return door.getDescription();
            default:
                return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return "Try to type 'look around', 'read DoD', or 'go to hallway', or 'go to loo'."
                + super.getHelp();
    }
}
