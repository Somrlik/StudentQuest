package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.util.ArrayList;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class WorldMap {

    private ArrayList<Location> locationsGrid;

    public WorldMap(int size) {
        this.locationsGrid = new ArrayList<Location>(size); //10*10
    }

    public Location getLocationAt(int i, int j) {
        return locationsGrid.get(i * 10 + j);
    }

    public void setLocationAt(int i, int j, Location loc) {
        locationsGrid.set(i * 10 + j, loc);
    }


}
