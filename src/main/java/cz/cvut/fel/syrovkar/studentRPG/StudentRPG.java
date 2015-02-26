package cz.cvut.fel.syrovkar.studentRPG;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Attribute;
import cz.cvut.fel.syrovkar.studentRPG.utils.LoggingHelper;

/**
 * Holds main information and technical initialization of engine.
 *
 * Created by Karel on 19. 2. 2015.
 */
public class StudentRPG {

    public static void main(String[] args) {

        LoggingHelper.LOGGER.info("Running the stuff.");

        Player plr = new Player();
        plr.addAttribute("Health", 20);
        plr.addAttribute("Health", 15);
        plr.addAttribute("Strenght", 10);
        System.out.println(plr.toString());

        plr.removeAttribute("Strenght");
        System.out.println(plr.toString());

        Attribute atr1 = new Attribute("Blah", 0);
        Attribute atr2 = new Attribute("Blah", 20);
        System.out.println(atr1.equals(atr2));

        System.out.println(plr.hasAttribute("Health"));



    }
}
