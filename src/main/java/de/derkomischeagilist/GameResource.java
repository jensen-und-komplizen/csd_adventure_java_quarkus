package de.derkomischeagilist;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/game")
public class GameResource {

    private final Adventure adventure;

    @Inject
    AdventureService adventureService;

    public GameResource(AdventureService adventureService) {
        this.adventureService = adventureService;
        adventure = adventureService.getAdventure();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String game() {
        return "<html><head>" +
                "<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"   integrity=\"sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=\" crossorigin=\"anonymous\"></script>"
                +
                "<script src=\"/game.js\"></script>" +
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"> \n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin> \n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Space+Mono:wght@400;700&family=VT323&display=swap\" rel=\"stylesheet\">"
                +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"/game.css\" />" +
                "</head><body><div class=\"container\"><div id=\"gameInfo\"><h1>You are in the loo</h1><p>Welcome to our new Adventure!<br>"
                +
                adventure.Begin() +
                "</p></div><form id=\"commandForm\" ><input id=\"command\" type=\"text\"/></form>" +
                "</div></body></html>";
    }
}
