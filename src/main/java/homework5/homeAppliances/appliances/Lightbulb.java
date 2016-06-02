package homework5.homeAppliances.appliances;

/**
 * Created by root.
 */
public class Lightbulb extends Appliance {
    static int[] lightPowers = {60,75,100,150,200};
    public Lightbulb(){
        super("Лампочка",lightPowers[random(0,(lightPowers.length - 1))],randomStatus());
    }
}
