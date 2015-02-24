package cz.cvut.fel.syrovkar.studentRPG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karel on 19. 2. 2015.
 */
public class StudentRPG {

    public static void main(String[] args) {


        List<Attribute> atrbs = new ArrayList<Attribute>();
        atrbs.add(new Attribute("Strenght", 20));
        atrbs.add(new Attribute("Intelligence", 0.3));
        Player plr = new Player("Player 1", atrbs);
        System.out.println(plr.toString());



    }
}
