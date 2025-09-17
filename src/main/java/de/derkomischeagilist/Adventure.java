package de.derkomischeagilist;

import de.derkomischeagilist.Rooms.Hallway;
import de.derkomischeagilist.Rooms.Kitchen;
import de.derkomischeagilist.Rooms.Loo;
import de.derkomischeagilist.Rooms.Room;
import de.derkomischeagilist.Rooms.TeamOffice;
import de.derkomischeagilist.Rooms.WashRoom;

public class Adventure {

    private int counter;
    protected Room currentRoom;
    private Loo loo;
    protected Room washroom;
    private Hallway hallway;
    private Room teamOffice;
    private Room kitchen;
    private String lastResponse;

    private String[] jokes = new String[] {
            "Why do we tell actors to 'break a leg?' - Because every play has a cast ;)",
            "Chuck Norris wins at Planning Poker.",
            "Why don't scientists trust atoms? Because they make up everything!",
            "Why was the JavaScript developer sad? - Because he didn’t know how to 'null' his feelings."
    };

    public String[] getJokes() {
        return this.jokes;
    }

    int jokeCounter = 0;

    public Adventure() {
        loo = new Loo();
        washroom = new WashRoom();
        hallway = new Hallway();
        teamOffice = new TeamOffice();
        kitchen = new Kitchen();
        currentRoom = loo;
        counter = 0;
        lastResponse = "";
    }

    public String tell(String command) {
        String response = "";
        switch (command.toLowerCase()) {
            case "commit suicide":
                loo.resetCounter();
                currentRoom = loo;
                response = currentRoom.getDescription() + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "look at a joke":
            case "read a joke":
                if (currentRoom == loo) {
                    response = jokes[jokeCounter++ % jokes.length];
                } else {
                    response = "There is no joke in this room.";
                }
                break;
            case "read jokes":
            case "look at jokes":
                for(String joke : jokes) {
                    response = response + joke + "\n";
                }
                break;
            case "look around":
                response = currentRoom.getDetailedDescription();
                break;
            case "count":
                counter++;
                response = "The counter is at " + counter;
                break;
            case "go to washroom":
                currentRoom = washroom;
                response = currentRoom.getDescription() + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "go to hallway":
                currentRoom = hallway;
                response = currentRoom.getDescription() + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "go to loo":
                loo.resetCounter();
                currentRoom = loo;
                response = "You are on the loo again. Still smelly." + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "go to team office":
                currentRoom = teamOffice;
                response = currentRoom.getDescription() + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "go to kitchen":
                currentRoom = kitchen;
                response = currentRoom.getDescription() + "\n\n" + currentRoom.getDetailedDescription();
                break;
            case "help":
                response = currentRoom.getHelp();

                if (response == null || response.length() <= 0)
                    response = "There is no help for you!";

                break;
            default:
                return currentRoom.handleCommand(command);
        }
        lastResponse = response;
        return response;
    }

    public String Begin() {
        lastResponse = currentRoom.getDescription();
        lastResponse += currentRoom.getDetailedDescription();
        return lastResponse;
    }

    public String Begin(String joke) {
        jokes = new String[] { joke };
        return Begin();
    }

    public Location whereAreWe() {
        if (currentRoom.getDescription().equals("You enter a room that looks like a washroom.")) {
            return Location.WASHROOM;
        }
        return Location.LOO;
    }
}
