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
        return "You see a pretty dirty door, with some nasty jokes on it. There are three pieces of toilet paper on the ground. Next to you are a coin and a few magazines."
                + "<br/>"
                + "Obviously you can reach the washroom through the dirty door."
                + "<br/>"
                + "In your pocket you find a card that says you are a pathetic scrum developer, PSD";
    }

    public String handleCommand(String command) {
        switch (command.toLowerCase()) {
            case "look at magazines":
                return "You see a very much used Micky Mouse magazine, a very old and unusable playboy and what seems to be a scrum guide 2009 in mint condition.";
            case "look at toilet paper":
                toiletPaperCount++;
                switch (toiletPaperCount) {
                    case 1:
                        return "On the first piece is written: \"Scrum Master: Nobody ever comes to my retros... I need to get out of here.\" There are more pieces on the ground.";
                    case 2:
                        return "On the second piece is written: \"Product Owner: My developers are way too slow.\" There is one more piece on the ground.";
                    case 3:
                        toiletPaperCount = 0;
                        return "On the last piece is written: \"Developers: We have too many meetings.\" I remember. I need to find my Scrum team to help them get out of here.";
                }
            case "go through door":

            default:
                return "you wake up on the Loo"
                        + "\n"
                        + super.handleCommand(command);
        }

    }

    public String getHelp() {
        return super.getHelp()
                + "try to 'look around', 'look at magazines' (better get your gloves), 'look at toilet paper' or just 'use door to washroom' to escape the smell.";
    }
}
