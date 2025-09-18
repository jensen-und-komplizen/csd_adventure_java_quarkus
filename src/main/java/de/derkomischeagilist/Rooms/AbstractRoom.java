package de.derkomischeagilist.Rooms;

public abstract class AbstractRoom implements Room {
    @Override
    public String handleCommand(String command) {
        return String.format("❌ %s" +
                "<br /><br />" +
                "%s", formatCommand(command), this.getHelp());
    }

    @Override
    public String getHelp() {
        return " If you want to restart, just try to 'commit suicide'. If you're feeling lost use the command 'help'.";
    }

    private String formatCommand(String command) {
        return String.format("<span style='color: #d50000; font-weight: bold; font-size: 1.2em;'>Sorry, I don't understand '%s'</span>", command);
    }
}
