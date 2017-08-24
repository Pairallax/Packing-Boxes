package moving.logic;

import moving.domain.*;

import java.util.*;

public class Packer {
    private int boxesVolume;
    private ArrayList<Box> boxes = new ArrayList<Box>();

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    /*
    ASSUME: A Thing's volume will NEVER exceed a Box's maximumCapacity
     */
    public List<Box> packThings(List<Thing> things) {
        useNewBox();

        for (Thing thing : things) {
            boolean boxesEligible = false;
            for (Box box : boxes) {
                boolean addTry = isAdded(thing, box);
                if (addTry) {
                    boxesEligible = true;
                    break;
                }

            }

            if(!boxesEligible){
                addToNewBox(thing);
            }
        }

        return this.boxes;
    }

    public boolean isAdded(Thing thing, Box currentBox) {
        return currentBox.addThing(thing);
    }

    public void useNewBox() {
        this.boxes.add(new Box(this.boxesVolume));
    }

    public void addToNewBox(Thing thing){
        Box newBox = new Box(this.boxesVolume);
        newBox.addThing(thing);
        this.boxes.add(newBox);
    }
}