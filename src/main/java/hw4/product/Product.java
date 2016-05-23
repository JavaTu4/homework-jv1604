package hw4.product;

/**
 * Created by root.
 */
public class Product {
    private int id;
    private String name;
    private int upc;
    private String manufacturer;
    private int price;
    private int storageLife;

    static Product[]products;

    static String[] names = {"Сыр", "Колбаса", "Йогурт", "Хлеб", "Конфеты", "Шоколад", "Круассаны", "Пиво", "Вода", "Банан"};
    static String[] manufacturers = {"Китай", "Украина", "Россия", "Америка", "Беларуссия"};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getUpc() {
        return upc;
    }
    public void setUpc(int upc) {
        this.upc = upc;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getStorageLife() {
        return storageLife;
    }
    public void setStorageLife(int storageLife) {
        this.storageLife = storageLife;
    }

    public Product(int id) {
        this.id = id;
        this.name = names[random(0,(names.length - 1))];
        this.upc = random(10000000,99999999);
        this.manufacturer = manufacturers[random(0,(manufacturers.length - 1))];
        this.price = random(50,500);
        this.storageLife = random(5,180);
    }

    @Override
    public String toString() {
        return "["+id+" "+name+" ["+upc+"] "+manufacturer+" "+price+" грн. "+storageLife+" дней]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
