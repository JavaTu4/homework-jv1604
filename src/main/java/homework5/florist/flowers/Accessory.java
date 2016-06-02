package homework5.florist.flowers;

/**
 * Created by root.
 */
public class Accessory {
    private String type;
    private int price;

    static String[] types = {"Корзина", "Бантик", "Плёнка", "Лента"};

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public static String[] getTypes() {
        return types;
    }
    public static void setTypes(String[] types) {
        Accessory.types = types;
    }

    public Accessory(String type, int price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        return "[Аксессуар {"+type+" цена = "+price+" грн.}]";

    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
