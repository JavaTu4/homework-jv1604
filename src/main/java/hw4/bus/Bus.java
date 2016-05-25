package hw4.bus;

/**
 * Created by root.
 */
public class Bus {
    private String driverInfo;
    private String busNumber;
    private String route;
    private String manufacturer;
    private int year;
    private int mileage;

    static Bus[]buses;

    static String[] initials = {"А", "Б", "В", "Г", "Д", "И", "Н", "К", "Р", "П", "Ф", "С", "Л", "М", "Ю"};
    static String[] surnames = {"Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев", "Виноградов", "Богданов", "Воробьёв"};
    static String[] regNumbers = {"АА", "АБ", "АС", "АД", "АЕ", "АФ", "АЗ", "АЖ", "АЗ", "АВ" };
    static String[] routes = {"1168", "1152", "65", "11", "302", "240", "159", "33", "258", "89"};
    static String[] manufacturers = {"Еталон", "Паз", "Mercedes", "Iveco", "Volvo", "Маз", "Icarus"};

    public String getDriverInfo() {
        return driverInfo;
    }
    public void setDriverInfo(String driverInfo) {
        this.driverInfo = driverInfo;
    }

    public String getBusNumber() {
        return busNumber;
    }
    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getRoute() {
        return route;
    }
    public void setRoute(String route) {
        this.route = route;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Bus() {
        this.driverInfo = surnames[random(0,(surnames.length - 1))]+" "+
                initials[random(0,(initials.length - 1))]+"."+
                initials[random(0,(initials.length - 1))]+".";
        this.busNumber = regNumbers[random(0,(regNumbers.length - 1))]+" "+random(1000,9999)
                +" "+regNumbers[random(0,(regNumbers.length - 1))];
        this.route = routes[random(0,(routes.length - 1))];
        this.manufacturer = manufacturers[random(0,(manufacturers.length - 1))];
        this.year = random(1997,2015);
        this.mileage = random(1000,100000);
    }

    @Override
    public String toString() {
        return "["+driverInfo+" ["+busNumber+"] Маршрут № ["+route+"] "+manufacturer+" с "+year+" года "+mileage+" км]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
