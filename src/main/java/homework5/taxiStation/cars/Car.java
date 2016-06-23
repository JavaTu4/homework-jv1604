package homework5.taxiStation.cars;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Car {
    private String manufacturer;
    private String model;
    private int price;
    private int fuelConsumption;
    private int maxSpeed;

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String model, int price, int fuelConsumption, int maxSpeed) {
        this.manufacturer = "Lada";
        this.model = model;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Автомобиль{ " +
                manufacturer +
                " " + model +
                ", Цена = " + price +
                " $, Расход топлива = " + fuelConsumption +
                " л/100 км., Скорость=" + maxSpeed +
                " км/ч }";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public class CarFuelConsumptionComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return o1.getFuelConsumption() - o2.getFuelConsumption();
        }
    }
}
