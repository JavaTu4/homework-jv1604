package homework5.transport.wagons;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Wagon {
    private String type;
    private int passengers;
    private int baggage;
    private int comfortLevel;

    static String[] types = {"Люкс", "Купэ", "Плацкарт", "Общий"};

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getBaggage() {
        return baggage;
    }
    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
    public void setComfortLevel(int comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public Wagon(String type, int passengers, int baggage, int comfortLevel) {
        this.type = type;
        this.passengers = passengers;
        this.baggage = baggage;
        this.comfortLevel = comfortLevel;
    }

    @Override
    public String toString() {
        return "Вагон {" +
                "Тип = " + type +
                ", Число пассажиров = " + passengers +
                " человек, Вес багажа = " + baggage +
                " кг.}";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public class WagonComfortLevelComparator implements Comparator<Wagon>{

        @Override
        public int compare(Wagon o1, Wagon o2) {
            return o1.getComfortLevel() - o2.getComfortLevel();
        }
    }

}
