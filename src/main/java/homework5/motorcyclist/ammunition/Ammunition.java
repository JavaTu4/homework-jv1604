package homework5.motorcyclist.ammunition;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Ammunition {

    private String type;
    private int weight;
    private int price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Экипировка {" +
                "тип = " + type +
                ", вес=" + weight +"gramm"+
                ", цена =" + price + "UAH" +
                '}';
    }

    public static String [] types = {"Шлем", "Наколенники", "Защита груди", "Защита спины", "Курка", "Штаны","Ботнки", "Балаклавы"};

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public Ammunition(String type) {
        this.type = type;
        this.weight = random(500,1500);
        this.price = random(1000,10000);
    }

    public class AmmunitionWeightComparator implements Comparator <Ammunition>{

        @Override
        public int compare(Ammunition o1, Ammunition o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
