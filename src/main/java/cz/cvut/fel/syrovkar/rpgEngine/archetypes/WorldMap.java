package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Wraps locations in a nice class.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class WorldMap {

    private static final Logger LOG = Logger.getLogger(WorldMap.class.getName());

    private ArrayList<Location> locationsGrid;

    private int i, j;

    private int currentI, currentJ;

    public WorldMap(int i, int j) {
        this.locationsGrid = new ArrayList<Location>(i * j); //10*10

        this.i = i;
        this.j = j;

        for (int a = 0; a < i * j; a++) {
            locationsGrid.add(new Location("Dummy Location", "dummy", -1, -1));
        }


        LOG.fine("World map build with size " + i * j + " or " + locationsGrid.size());
    }

    public Location getLocationAt(int i, int j) {
        if (i > this.i || j > this.j || i < 0 || j < 0 || i * this.i + j >= this.i * this.j) {
            LOG.fine("Failed to getLocationAt i:" + i + " j: " + j);
            return null;
        }
        return locationsGrid.get(i * this.i + j);
    }

    public void setLocationAt(int i, int j, Location loc) {

        if (i < 0 || j < 0) {
            LOG.severe("Failed to setLocation - wrong parse? Location:" + loc.toString());
            return;
        }

        locationsGrid.set(i * this.i + j, loc);

        LOG.finer("Location at i:" + i + " j:" + j + " set with id = " + loc.getId());
    }

    public Location getLocationWithId(String id) {
        for (Location l : locationsGrid) {
            if (l.getId().equals(id)) return l;
        }
        LOG.info("Unable to find location with id " + id);
        return null;
    }

    public int getCurrentI() {
        return currentI;
    }

    public void setCurrentI(int currentI) {
        this.currentI = currentI;
    }

    public int getCurrentJ() {
        return currentJ;
    }

    public void setCurrentJ(int currentJ) {
        this.currentJ = currentJ;
    }
}
