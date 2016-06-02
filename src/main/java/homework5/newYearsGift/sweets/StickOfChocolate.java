package homework5.newYearsGift.sweets;

/**
 * Created by root.
 */
public class StickOfChocolate extends Sweet{

    static String[] names = {"Рошен", "Корона", "Свиточ", "Милка", "Миллениум"};

    public StickOfChocolate() {
        super("Плитка шоколада",
                names[random(0,(names.length - 1))],
                100,
                10);
    }
}
