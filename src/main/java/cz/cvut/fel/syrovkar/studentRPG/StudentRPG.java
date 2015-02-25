package cz.cvut.fel.syrovkar.studentRPG;

/**
 * Created by Karel on 19. 2. 2015.
 */
public class StudentRPG {

    public static void main(String[] args) {

        Player plr = new Player();
        plr.addAttribute("Health", 20);
        plr.addAttribute("Strenght", 10);
        System.out.println(plr.toString());

    }
}
