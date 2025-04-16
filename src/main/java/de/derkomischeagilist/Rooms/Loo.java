package de.derkomischeagilist.Rooms;

public class Loo extends AbstractRoom {

    private int toiletPaperCount;
    private boolean coinPickedUp;
    private boolean coinScrumMaster;
    private boolean talkingToScrumMaster;

    public Loo() {
        toiletPaperCount = 0;
        this.coinPickedUp = false;
        this.coinScrumMaster = false;
        this.talkingToScrumMaster = false;
    }

    public void resetCounter() {
        toiletPaperCount = 0;
    }

    public String getDescription() {
        return "You wake up on the loo. You have no idea where or who you are.";
    }

    public String getDetailedDescription() {
        return "You see a pretty dirty <span class=\"hint\">door</span> with some nasty <span class=\"hint\">jokes</span> on it. There are four pieces of <span class=\"hint\">toilet paper</span> "
                + (coinPickedUp ? "" : "and a <span class=\"hint\">coin</span> " ) + "on the ground. Next to you are a few <span class=\"hint\">magazines</span>. "
                + "In the corner of the room you see a shady looking guy, who seems to be a <span class=\"hint\">Scrum Master</span>."
          + "<br/>"
          + "In your pocket you find a card that says you are a \"Pathetic Scrum Developer (PSD)\"";
    }

    public String handleCommand(String command){

        if (talkingToScrumMaster) {
            switch (command.toLowerCase()){
                case "a":
                case "definition of done":
                    coinScrumMaster = true;
                    talkingToScrumMaster = false;
                    return "You answered the riddle correctly. The Scrum Master is happy and gives you a <span class=\"hint\">coin</span>.";
                case "d":
                case "ignore":
                    talkingToScrumMaster = false;
                    return "You ignore the Scrum Master. He looks disappointed.";
                default:
                    return "You need to answer the riddle correctly my friend. Try again.";
            }
        }
        switch(command.toLowerCase()) {
            case "look at magazines":
                return "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a <span class=\"hint\">Scrum Guide 2009</span> in mint condition.";
            case "read scrum guide 2009":
            case "read scrum guide":
                return "You read the Scrum Guide 2009. It is very interesting. You learned a lot about Scrum. You feel like you are a better Scrum Developer now. You feel like there might be a newer version with updates and more innovations around.";
            case "look at toilet paper":
                toiletPaperCount++;
                switch (toiletPaperCount) {
                    case 1: return "On the first piece is written: \"Scrum Master: Nobody ever comes to my retros... I need to get out of here.\" There are more pieces on the ground.";
                    case 2: return "Another one states: \"A foo walks into a bar.\" More to read on the floor.";
                    case 3: return "Next piece says: \"Product Owner: My developers are way too slow.\" There is one more piece on the ground.";
                    case 4:
                        toiletPaperCount = 0;
                        return "On the last piece is written: \"Developers: We have too many meetings.\" I remember. I need to find my Scrum team to help them get out of here.";
                }
            case "look at door":
                return "You see a door. It leads to the washroom.";
            case "pick up coin":
                if (coinPickedUp) {
                    return "You already picked up the coin.";
                }
                coinPickedUp = true;
                return "You picked up the coin.";
            case "talk to scrum master":
                if (coinScrumMaster) {
                    return "\"You cannot learn anymore from me!.\"";
                }
                talkingToScrumMaster = true;
                return "You talk to the shady looking Scrum Master. Manically he looks into your eyes and says: I am the Scrum Master and I have a riddle for you: \n" +
                        "What is part of the scrum framework?\n" +
                        "<span class=\"hint\">a) Definition of Done</span>\n" +
                        "<span class=\"hint\">b) Definition of Ready</span>\n" +
                        "<span class=\"hint\">c) Acceptance Criteria</span>\n" +
                        "<span class=\"hint\">d) ignore him</span>";
            case "go through door":

            default:
                return super.handleCommand(command);
        }

    }

    public String getHelp() {
        return "Try to 'look around', 'look at magazines' (better get your gloves), 'look at door', 'look at toilet paper', 'pick up coin', 'talk to scrum master' 'read a joke' or just 'go to washroom' to escape the smell." + super.getHelp();
    }
}
