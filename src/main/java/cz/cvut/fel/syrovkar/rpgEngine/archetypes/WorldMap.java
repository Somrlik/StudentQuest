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

    public WorldMap(int size) {
        this.locationsGrid = new ArrayList<Location>(size); //10*10

        for (int i = 0; i < 100; i++) {
            locationsGrid.add(new Location("Dummy Location", "dummy"));
        }


        LOG.fine("World map build with size " + size + " or " + locationsGrid.size());
    }

    public Location getLocationAt(int i, int j) {
        return locationsGrid.get(i * 10 + j);
    }

    public void setLocationAt(int i, int j, Location loc) {
        locationsGrid.set(i * 10 + j, loc);

        LOG.finer("Location at i:" + i + " j:" + j + " set with id = " + loc.getId());
    }

    public Location getLocationWithId(String id) {
        for (Location l : locationsGrid) {
            if (l.getId().equals(id)) return l;
        }
        LOG.info("Unable to find location with id " + id);
        return null;
    }
}
