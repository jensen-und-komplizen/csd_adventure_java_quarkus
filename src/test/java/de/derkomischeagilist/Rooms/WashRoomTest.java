package de.derkomischeagilist.Rooms;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.derkomischeagilist.Adventure;
import org.junit.jupiter.api.Test;

class WashRoomTest {

  Adventure adventure = new Adventure();
  WashRoom washRoom = new WashRoom();

  @Test
  void EnteringWashroomShowsDetail() {
    //When I go into the washroom
    String actual = adventure.tell("go to washroom");
    //Then i can see a sink and a door
    assertThat(actual, containsStringIgnoringCase("incredibly nasty sink"));
  }

  @Test
  void showPaperBinInLookAroundInWashroom() {
    adventure.tell("go to washroom");
    String result = adventure.tell("look around");
    assert (result.contains("There is a <span class=\"hint\">bin</span> next to the sink."));
  }

  @Test
  void showLooDoorInLookAroundInWashroom() {
    adventure.tell("go to washroom");
    String result = adventure.tell("look around");
    assert (result.contains("There is a door to the <span class=\"hint\">loo</span>."));
  }

  @Test
  void showContentOfBinWhenLookingAtBin() {
    adventure.tell("go to washroom");
    String result = adventure.tell("look at bin");
    assert (result.contains(
        "You walk closer to the bin. It is very dirty and smells like an old wet chicken. Inside you see a lot of used paper towels. No one would reach in here."));
  }

  @Test
  void showDifferentContentOfBinWhenLookingAtBinTwice() {
    adventure.tell("go to washroom");
    String result = adventure.tell("look at bin");
    assert (result.contains(
        "You walk closer to the bin. It is very dirty and smells like an old wet chicken. Inside you see a lot of used paper towels. No one would reach in here."));
    result = adventure.tell("look at bin");
    assert (result.contains("It still smells like an old wet chicken."));
    result = adventure.tell("look at bin");
    assert (result.contains("It still smells like an old wet chicken."));
    result = adventure.tell("look at bin");
    assert (result.contains("Please you don't want to smell it anymore."));

  }

  @Test
  void getDetailedDescription() {
    assertTrue(washRoom.getDetailedDescription().toLowerCase().contains("coin"));
  }
}