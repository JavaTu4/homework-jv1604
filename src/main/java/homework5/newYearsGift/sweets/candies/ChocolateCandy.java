package homework5.newYearsGift.sweets.candies;

/**
 * Created by root.
 */
public class ChocolateCandy extends Candy {

    static String[]names = {"Белочка","Ромашка","Красный мак","Каракум"};

    public ChocolateCandy() {
        super("Шоколадная конфета",
                names[random(0,(names.length - 1))],
                random(5,10),
                random(1,10));
    }
}
