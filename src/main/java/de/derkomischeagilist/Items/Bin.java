package de.derkomischeagilist.Items;

public class Bin {

    private int counter;

    public Bin() {
        this.counter = 0;
    }

    public String getDescription() {
        counter += 1;
        if (counter == 1) {
            return "You walk closer to the bin. It is very dirty and smells like an old wet chicken. Inside you see a lot of used paper towels. No one would reach in here.";
        } else if (counter >= 4) {
            return "Please you don't want to smell it anymore.";
        }
        return "It still smells like an old wet chicken.";
    }

}
