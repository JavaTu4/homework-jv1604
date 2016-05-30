package homework5.florist.flowers;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Flower {
    private int price;
    private int freshness;
    private int stemLenght;
    private String type;
    private String colour;

    static String[] colours = {"Красный", "Белый", "Желтый"};

    public static String[] getColours() {
        return colours;
    }
    public static void setColours(String[] colours) {
        Flower.colours = colours;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getFreshness() {
        return freshness;
    }
    public void setFreshness(int freshness) {
        this.freshness = freshness;
    }
    public int getStemLenght() {
        return stemLenght;
    }
    public void setStemLenght(int stemLenght) {
        this.stemLenght = stemLenght;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

    public Flower(int price, int freshness, int stemLenght, String type, String colour) {
        this.price = price;
        this.freshness = freshness;
        this.stemLenght = stemLenght;
        this.type = type;
        this.colour = colour;
    }

    public Flower() {
        price = random(15,75);
        freshness = random(50,100);
        stemLenght = random(10,30);
        colour = colours[random(0,(colours.length - 1))];
    }

    @Override
    public String toString() {
        return "[Цветок {"+type+" "+colour+" цена = "+price+" грн. свежесть = "+freshness+" % длинна стебля = "+stemLenght+" cm.}]";
    }

    public class FreshnessComparator implements Comparator<Flower>{
        @Override
        public int compare(Flower o1, Flower o2) {
            return o1.getFreshness() - o2.getFreshness();
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }


}
