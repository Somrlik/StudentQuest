package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.gui.FPSMeter;
import cz.cvut.fel.syrovkar.rpgEngine.gui.HealthOverlay;
import cz.cvut.fel.syrovkar.rpgEngine.gui.InventoryScreen;

/**
 * Initializes some random stuff.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class MiscInit {

    public static void init(GameRegistry gameRegistry) {

        HealthOverlay ho = new HealthOverlay();

        gameRegistry.addOverlay(ho);

        InventoryScreen is = new InventoryScreen();

        gameRegistry.addOverlay(is);

        FPSMeter fps = new FPSMeter();

        gameRegistry.addOverlay(fps);
    }
}
