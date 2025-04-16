package de.derkomischeagilist.Rooms;

public class Hallway extends AbstractRoom {
    private boolean hasEnoughCoins() {
        // TODO implement method to get the current amount of coins and check if it is enough
        return false;
    }

    @Override
    public String getDescription() {
        return "Welcome to the hallway to hell.";
    }

    @Override
    public String getDetailedDescription() {
        return "Welcome to the very dark hallway to hell. You see 3 doors. One door leads to the kitchen, one to the washroom. At the end you see a spooky looking door. On one of the walls there is a dirty poster.";
    }

    @Override
    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "inspect the spooky door":
                return "You see a rugged and sturdy steel door with cryptic symbols on it. Above the door is a sign saying \"EXIT\". "
                		+ "The door is covered in cobweb and next to it is a rusty coin slot. The coin slot has a post-it attached to it saying \"Please insert your coins\". "+
                        "You could try to look around to get more coins.";
            case "inspect the poster":
                return "---------------------------------\n" +
                        "| The mighty Scrum Values are \n" +
                        "| commitment\n" +
                        "| courage\n" +
                        "| focus\n" +
                        "| openness\n" +
                        "| respect\n" +
                        "--------------------------------";
            case "insert coins":
                return handleDefaultCase();
            default: {
                return super.handleCommand(command);
            }
        }
    }

    private String handleDefaultCase() {
        if (hasEnoughCoins()) {
                return "You made it! In front of you are a lot of people, who start clapping as they see you. " +
                        "You realize, that you are standing on a podium. " +
                        "Some guy hurries over and hands over a certificate, which says that you are now a " +
                        "'Certified Scrum Developer'. " +
                        "Congratulations!!!";
        } else {
            return "Nothing happens. After 5 seconds, the coin slot returns the coins. " +
                    "You hear a voice saying: \"Please insert more coins\". " +
                    "You could try to unlock the door with 'insert coins'.";
        }
    }

    @Override
    public String getHelp() {
        return "Try to 'look around' or 'go to team office'. You can also 'go to washroom' to go to the washroom or 'go to kitchen' to visit pizza the hut or maybe try to 'inspect the spooky door'. If you are really interested in the poster then 'inspect the poster'" + super.getHelp();
    }
}
