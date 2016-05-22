package hw4.house;

/**
 * Created by root.
 */
public class House {
    private int id;
    private int apartmentNumber;
    private int square;
    private int level;
    private int numberOfRooms;
    private String street;
    private String buildingType;
    private int lifetime;

    public static House[]houses;

    static String[]streets = {"Сумская", "Пушкинская","Рымарская", "Полтавский шлях","Красношкольная набережная", "Петровского"};
    static String[]buildingTypes = {"Офисное здание","Жилое здание","Новопостроенное здание"};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }
    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public int getSquare() {
        return square;
    }
    public void setSquare(int square) {
        this.square = square;
    }

    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }
    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getLifetime() {
        return lifetime;
    }
    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public House(int id, int apartmentNumber, int square, int level, int numberOfRooms, String street, String buildingType, int lifetime) {
        this.id = id;
        this.apartmentNumber = apartmentNumber;
        this.square = square;
        this.level = level;
        this.numberOfRooms = numberOfRooms;
        this.street = street;
        this.buildingType = buildingType;
        this.lifetime = lifetime;
    }

    public House(int id){
        this.id = id;
        this.apartmentNumber = random(1,100);
        this.square = random(25,200);
        this.level = random(1,24);
        this.numberOfRooms = random(1,5);
        this.street = streets[random(0,(streets.length - 1))];
        this.buildingType = buildingTypes[random(0,(buildingTypes.length - 1))];
        this.lifetime = random(1990,2016);
    }

    @Override
    public String toString() {
        return "["+id+" кв. № "+apartmentNumber+" "+square+" кв.метров "+level+" этаж "+numberOfRooms+" ком  ул. "+street+" "+buildingType+" с "+lifetime+" года]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
