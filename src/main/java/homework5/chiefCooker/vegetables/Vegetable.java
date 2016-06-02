package homework5.chiefCooker.vegetables;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Vegetable {
    private String name;
    private int weight;
    private double calorificValue;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getCalorificValue() {
        return calorificValue;
    }
    public void setCalorificValue(double calorificValue) {
        this.calorificValue = calorificValue;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vegetable(String name, int weight, double calorificValue) {
        this.name = name;
        this.weight = weight;
        this.calorificValue = (calorificValue / 100) * this.weight;
    }

    @Override
    public String toString() {
        return "Овощ { \""+name+"\", Вес = "+weight+" грамм, Калорийность = "+(int)calorificValue+" кал.}";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public class VegetableWeightComparator implements Comparator<Vegetable>{
        @Override
        public int compare(Vegetable o1, Vegetable o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
