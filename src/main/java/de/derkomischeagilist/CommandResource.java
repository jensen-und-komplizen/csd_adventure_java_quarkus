package de.derkomischeagilist;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/command")
public class CommandResource {

    private final Adventure adventure;

    @Inject
    AdventureService adventureService;

    public CommandResource(AdventureService adventureService) {
        this.adventureService = adventureService;
        adventure = adventureService.getAdventure();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @QueryParam("command")
    public String game(@QueryParam("command") String command) {
        var description = adventure.tell(command).replace("\r\n", "<br />").replace("\n", "<br />");
        return "<h1>You are in the " + adventure.whereAreWe().toString().toLowerCase() + "</h1>" + description;
    }
}
