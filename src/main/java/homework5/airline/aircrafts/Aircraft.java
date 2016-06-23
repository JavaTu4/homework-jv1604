package homework5.airline.aircrafts;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Aircraft {
    private String name;
    private String type;
    private int passengerCapacity;
    private int carryingCapacity;
    private int rangeOfFlight;
    private int fuelConsumption;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }
    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getRangeOfFlight() {
        return rangeOfFlight;
    }
    public void setRangeOfFlight(int rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public Aircraft(String name, String type, int passengerCapacity, int carryingCapacity, int rangeOfFlight, int fuelConsumption) {
        this.name = name;
        this.type = type;
        this.passengerCapacity = passengerCapacity;
        this.carryingCapacity = carryingCapacity;
        this.rangeOfFlight = rangeOfFlight;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Самолёт{ " +
                "Название: " + name +
                ",Тип " + type +
                ", Вместимость: " + passengerCapacity +
                " пассажиров, Грузоподъемность: " + carryingCapacity +
                " кг., Дальность полета: " + rangeOfFlight +
                " км., Потребление топлива: " + fuelConsumption +
                " кг/час }";
    }

    public class AircraftRangeComparator implements Comparator<Aircraft>{

        @Override
        public int compare(Aircraft o1, Aircraft o2) {
            return o1.getRangeOfFlight() - o2.getRangeOfFlight();
        }
    }


}
