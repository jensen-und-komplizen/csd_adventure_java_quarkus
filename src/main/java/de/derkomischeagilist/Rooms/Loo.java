package de.derkomischeagilist.Rooms;

public class Loo extends AbstractRoom {

    private int toiletPaperCount;

    public Loo() {
        toiletPaperCount = 0;
    }

    public void resetCounter() {
        toiletPaperCount = 0;
    }

    public String getDescription() {
        return "You wake up on the loo. You have no idea where or who you are.";
    }

    public String getDetailedDescription() {
        return "You see a pretty dirty door with some nasty <span class=\"hint\">jokes</span> on it. There are three pieces of <span class=\"hint\">toilet paper</span> and a <span class=\"hint\">coin</span> on the ground. Next to you are a few <span class=\"hint\">magazines</span>."
          + "<br/>"
          + "In your pocket you find a card that says you are a Pathetic Scrum Developer (PSD)";
    }

    public String handleCommand(String command){
        switch(command.toLowerCase()) {
            case "look at magazines":
                return "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a <span class=\"hint\">Scrum Guide 2009</span> in mint condition.";
            case "look at toilet paper":
                toiletPaperCount++;
                switch (toiletPaperCount) {
                    case 1: return "On the first piece is written: \"Scrum Master: Nobody ever comes to my retros... I need to get out of here.\" There are more pieces on the ground.";
                    case 2: return "Another one states: \"A foo walks into a bar.\" More to read on the floor.";
                    case 3: return "Next pices says: \"Product Owner: My developers are way too slow.\" There is one more piece on the ground.";
                    case 4:
                        toiletPaperCount = 0;
                        return "On the last piece is written: \"Developers: We have too many meetings.\" I remember. I need to find my Scrum team to help them get out of here.";
                }
            case "look at door":
                return "You see a door. It leads to the WashRoom.";
            case "go through door":

            default:
                return
                   "you wake up on the Loo"
                   + "\n"
                   + super.handleCommand(command);
        }

    }

    public String getHelp() {
        return "Try to 'look around', 'look at magazines' (better get your gloves), 'look at door', 'look at toilet paper', 'read a joke' or just 'use door to washroom' to escape the smell." + super.getHelp();
    }
}
