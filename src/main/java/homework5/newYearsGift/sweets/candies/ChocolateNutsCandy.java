package homework5.newYearsGift.sweets.candies;

/**
 * Created by root.
 */
public class ChocolateNutsCandy extends Candy {

    static String[]names = {"3 орешка","Грильяж","Сникерс","Блаженство"};

    public ChocolateNutsCandy() {
        super("Шоколадная конфета с орехами",
                names[random(0,(names.length - 1))],
                random(5,13),
                random(2,10));
    }
}
