Feature: There is a colleague in the kitchen, who wants to be nice to us

  Scenario: A colleague greets you
    Given we are in the kitchen
    When we look at the colleague
    Then he will greet us with "Hello dear friend!"

  Scenario: PizzaTheHut is mentioned in greeting info
    Given we are in the kitchen
    When we look at the colleague
    Then he will greet us with "Pizza The Hut"

  Scenario: PizzaTheHut is mentioned in greeting info
    Given we are in the kitchen
    When we look at the colleague
    Then he will greet us with "\"Hello dear friend! Want to have a slice of my pizza?\""