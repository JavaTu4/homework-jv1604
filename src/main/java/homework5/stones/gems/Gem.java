package homework5.stones.gems;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Gem {
    private String type;
    private int transparence;
    private double weight;
    private double price;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getTransparence() {
        return transparence;
    }
    public void setTransparence(int transparence) {
        this.transparence = transparence;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public Gem(String type, int transparence, double weight, double price) {
        this.type = type;
        this.transparence = transparence;
        this.weight = weight / 0.2;
        this.price = price * this.weight;
    }

    @Override
    public String toString() {
        return "Камень:{ "+type+", Прозрачность = "+transparence+" %, Вес = "
                +weight+" карат, Цена = "+price+" $ }";
    }

    public class GemPriceComparator implements Comparator<Gem>{
        @Override
        public int compare(Gem o1, Gem o2) {
           return (int) (o1.getPrice() - o2.getPrice());
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
