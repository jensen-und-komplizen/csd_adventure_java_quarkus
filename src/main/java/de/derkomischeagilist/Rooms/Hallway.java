package de.derkomischeagilist.Rooms;

public class Hallway extends AbstractRoom {
    private boolean keypadIsActive = false;

    public void resetKeypad() {
        keypadIsActive = false;
    }

    public void activateKeypad() {
        keypadIsActive = true;
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
                		+ "The door is covered in cobweb and next to it is a rusty keypad. The keypad has a post-it attached to it saying \"Please enter number of Scrum values.\". "
                		+ "You could try to unlock the door with 'use keypad'.";
            case "inspect the poster":
                return "---------------------------------\n" +
                        "| The mighty Scrum Values are \n" +
                        "| commitment\n" +
                        "| courage\n" +
                        "| focus\n" +
                        "| openness\n" +
                        "| respect\n" +
                        "--------------------------------";
            case "use keypad":
            case "use rusty keypad":
                activateKeypad();
                return "You need to enter the number of the Scrum values. If you have no clue, take a look around.";
            default: {
                return handleDefaultCase(command);
            }
        }
    }

    private String handleDefaultCase(String command) {
        if (keypadIsActive) {
            resetKeypad();
            if (command.equalsIgnoreCase("5")) {
                return "You made it! In front of you are a lot of people, who start clapping as they see you. " +
                        "You realize, that you are standing on a podium. " +
                        "Some guy hurries over and hands over a certificate, which says that you are now a " +
                        "'Certified Scrum Developer'. " +
                        "Congratulations!!!";
            }

            return "You hear a \"beep\", but nothing happens. " +
                    "If you want to retry, please enter the command 'use keypad' again.";
        }
        return super.handleCommand(command);
    }

    @Override
    public String getHelp() {
        return "Try to 'look around' or 'use door to team office'. You can also 'use door to washroom' to go to the washroom or 'use door to kitchen' to visit pizza the hut or maybe try to 'inspect the spooky door'. If you are really interested in the poster then 'inspect the poster'" + super.getHelp();
    }
}
