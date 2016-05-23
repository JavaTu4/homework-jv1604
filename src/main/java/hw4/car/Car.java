package hw4.car;

/**
 * Created by root.
 */
public class Car {
    private int id;
    private String manufacturer;
    private String model;
    private int yearOfManufacture;
    private String colour;
    private int price;
    private String registrationNumber;

    static Car[]cars;

    static String[] manufacturers = {"Bmw", "Mercedes", "Citroen", "Lada", "Toyota", "Mitsubishi", "Subaru", "Chevrolet", "Lexus", "Suzuki", "Zaz", "Opel", };
    static String[] models = {"Седан", "Внедорожник", "Кроссовер", "Купэ", "Кабриолет", "Родстер", "Спорткар"};
    static String[] colours = {"Красный", "Зелёный", "Белый", "Сниний", "Желтый", "Черный", "Оранжевый", "Голубой" };
    static String[] regNumbers = {"АА", "АБ", "АС", "АД", "АЕ", "АФ", "АЗ", "АЖ", "АЗ", "АВ" };

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

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

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Car(int id, String manufacturer, String model, int yearOfManufacture, String colour, int price, String registrationNumber) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.colour = colour;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public Car(int id){
        this.id = id;
        this.manufacturer = manufacturers[random(0,(manufacturers.length - 1))];
        this.model = models[random(0,(models.length - 1))];
        this.yearOfManufacture = random(1995,2015);
        this.colour = colours[random(0,(colours.length - 1))];
        this.price = random(1000,10000);
        this.registrationNumber = regNumbers[random(0,(regNumbers.length - 1))]+" "+random(1000,9999)
                +" "+regNumbers[random(0,(regNumbers.length - 1))];
    }

    @Override
    public String toString() {
        return "["+id+" "+manufacturer+" "+model+" "+yearOfManufacture+" г. выпуска "+colour+
                " "+price+" $ "+registrationNumber+"]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
