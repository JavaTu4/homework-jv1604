package homework5.newYearsGift.sweets;

/**
 * Created by root.
 */
public class PacketOfBiscuits extends Sweet {

    static String[]names = {"Юбилейное","Союзное","День и ночь","Клубничное"};

    public PacketOfBiscuits() {
        super("Пачка печенья",
                names[random(0,(names.length - 1))],
                150,
                5);
    }
}
