package homework5.newYearsGift.sweets.candies;

/**
 * Created by root.
 */
public class Lollipop extends Candy {
    static String []names = {"Мята", "Дюшес", "Барбарис", "Лимон"};
    public Lollipop() {
        super("Леденец",
                names[random(0,(names.length - 1))],
                random(3,8),
                random(5,15));
    }
}
