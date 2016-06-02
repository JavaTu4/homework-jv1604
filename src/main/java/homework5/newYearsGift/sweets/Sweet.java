package homework5.newYearsGift.sweets;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Sweet {
    private String type;
    private String name;
    private int weight;
    private int sugar;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSugar() {
        return sugar;
    }
    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public Sweet(String type, String name, int weight, int sugar) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "[ "+type+"{\""+name+"\", вес: "+weight+
                " г., процент содержания сахара: "+sugar+" %}]";
    }

    public class SweetTypeComparator implements Comparator<Sweet>{

        @Override
        public int compare(Sweet o1, Sweet o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
