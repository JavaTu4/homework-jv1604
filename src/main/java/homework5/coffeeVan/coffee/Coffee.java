package homework5.coffeeVan.coffee;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by root.
 */
public class Coffee {
    private String sort;
    private String physicalState;
    private double qualityLevel;
    private double volume;
    private double weight;
    private double price;
    private double ratio;

    public static String[] sorts = {"Арабика", "Робуста", "Арабика+Робуста", "Либерика"};
    public static String[] states = {"Зерно", "Молотый", "В банке(р)", "В пакетике(р)"};

    public String getSort() {
        return sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPhysicalState() {
        return physicalState;
    }
    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }

    public double getQualityLevel() {
        return qualityLevel;
    }
    public void setQualityLevel(double qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
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

    public double getRatio() {
        return ratio;
    }
    public void setRatio(double range) {
        this.ratio = range;
    }

    @Override
    public String toString() {
        return "Упаковка кофе{ " +
                "Сорт-[" + sort +
                "], Состояние-[" + physicalState +
                "], Качество-[" + qualityLevel +
                " %], Обьем-[" + volume +
                " cm3.], Вес-[" + weight +
                " g.]" +
                ", Цена-[" + price+" $] "+
                "Цена/качество " + ratio + " }";
    }

    public Coffee(String sort, String physicalState) {
        this.sort = sort;
        this.physicalState = physicalState;
        qualityLevel = random(1,3);
        volume = 0;
        weight = 0;
        price = 0;
        if (physicalState.equals(states[0])){
            weight = 10000;
            price = 25;
        }
        else if (physicalState.equals(states[1])){
            weight = 7500;
            price = 10;
        }
        else if (physicalState.equals(states[2])){
            weight = 4000;
            price = 8;
        }
        else if (physicalState.equals(states[3])){
            weight = 1000;
            price = 5;
        }

        if (sort.equals(sorts[0])){
            price = price + price * 1.25;
        }
        else if (sort.equals(sorts[1])){
            price = price * 1.50;
        }
        else if (sort.equals(sorts[2])){
            price = price * 1.3;
        }
        else if (sort.equals(sorts[3])){
            price = price * 1.44;
        }
        for (double i = 3;i > 0;i--){
            if (qualityLevel == i){
                price = price * (1.5 - (i / 10) * 2);
            }
        }
        volume = Math.rint(weight / 0.430);
        setPrice(Math.rint(price));
        ratio = (Math.rint(price / qualityLevel));
    }

    public class CoffeeRatioComparator implements Comparator<Coffee>{
        @Override
        public int compare(Coffee o1, Coffee o2) {
            return ((int) (o1.getRatio() - o2.getRatio()));
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
