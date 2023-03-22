package de.derkomischeagilist.Rooms;

public class Hallway extends AbstractRoom {
    @Override
    public String getDescription() {
        return "Welcome to the hallway to hell.";
    }

    @Override
    public String getDetailedDescription() {
        return "Welcome to the very dark hallway to hell. At the end you see a spooky looking door.";
    }

    @Override
    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "inspect the spooky door":
                return "You see a rugged and sturdy steel door with cryptic symbols on it. The door is covered in cobweb and next to it is a rusty keypad. If you feel brave enough you could 'open the spooky door'?";
            case "use spooky door":
                return "You made it! In front of you are a lot of people, who start clapping as they see you. " +
                        "You realize, that you are standing on a podium. " +
                        "Some guy hurries over and hands over a certificate, which says that you are now a " +
                        "'Certified Scrum Developer'. " +
                        "Congratulations!!!";
            default: return super.handleCommand(command);
        }
    }

    @Override
    public String getHelp() {
        return super.getHelp()+ "try to 'look around' or 'use door to team office'. You can also 'use door to washroom' to go to the washroom or 'use door to kitchen' to visit pizza the hut or maybe try to 'use spooky door'.";
    }
}
