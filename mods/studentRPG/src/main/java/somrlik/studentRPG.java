package somrlik;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.Mod;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Item;
import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;

/**
 * Created by Karel on 11. 3. 2015.
 */
@Mod(modId = "studentRPG", modName = "Student RPG")
public class studentRPG {

    public studentRPG() {

    }

    @Mod.Init
    public void init() {
        LoggingHelper.LOGGER.info("Init of studentRPG.");

        Game.gameRegistry.addItem(new Item("DrumBlam"));

        Game.player.addAttribute("Sex", "Male");
        Game.player.addAttribute("Age", 20);

        LoggingHelper.LOGGER.info("StudentRPG loaded");
    }

    @Override
    public String toString() {
        return "studentRPG{}";
    }
}
