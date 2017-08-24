package moving.domain;

import java.util.ArrayList;

public class Box implements Thing {
    private int maximumCapacity;
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private int currentCapacity;

    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.currentCapacity = maximumCapacity;
    }

    public boolean addThing(Thing thing){
        int thingVolume = thing.getVolume();

        if(thingVolume < this.currentCapacity){
            this.currentCapacity -= thingVolume;
            this.things.add(thing);
            return true;
        }
        else{
            return false;
        }
    }

    public int getVolume(){
        return this.currentCapacity;
    }

}