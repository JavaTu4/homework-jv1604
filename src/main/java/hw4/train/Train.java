package hw4.train;

import java.util.Arrays;

/**
 * Created by root.
 */
public class Train {
    private String destination;
    private int number;
    private String timeOfDeparture;
    private  int numberOfAllSeats;
    private String [] typeOfSeats = new String [2];
    private int [] numberOfSeats = new int[typeOfSeats.length];


    static Train[]trains;

    static String[] destinations = {"Киев", "Харьков", "Одесса", "Днепропетровск", "Донецк", "Запорожье", "Львов", "Кривой Рог", "Николаев", "Мариуполь"};
    static int[] seats = { 320, 400};
    static String[] typesOfSeats = {"Общие", "Плацкарт", "Купэ", "Люкс"};
    static String[] hours = autoHours();
    static String[] autoHours(){
        String[] h = new String[24];
        for (int i = 0;i < 10;i++){
            h[i] = "0"+i;
        }
        for (int j = 10;j < h.length;j++){
            h[j] = ""+j;
        }
        return h;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getTimeOfDeparture() {
        return timeOfDeparture;
    }
    public void setTimeOfDeparture(String timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public int getNumberOfAllSeats() {
        return numberOfAllSeats;
    }
    public void setNumberOfAllSeats(int numberOfAllSeats) {
        this.numberOfAllSeats = numberOfAllSeats;
    }

    public String[] getTypeOfSeats() {
        return typeOfSeats;
    }
    public void setTypeOfSeats(String[] typeOfSeats) {
        this.typeOfSeats = typeOfSeats;
    }

    public int[] getNumberOfSeats() {
        return numberOfSeats;
    }
    public void setNumberOfSeats(int[] numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Train() {
        this.destination = destinations[random(0,(destinations.length - 1))];
        this.number = random(25,99);
        this.timeOfDeparture = hours[random(0,(hours.length - 1))]+":"+random(0,5)+random(1,9);
        this.numberOfAllSeats = seats[random(0,(seats.length - 1))];
        this.typeOfSeats = autoTypeOfSeats();
        this.numberOfSeats = autoNumbersOfSeats();
    }

    @Override
    public String toString() {
        return "["+destination+" ("+number+") ("+timeOfDeparture+") Всего мест: "+
                numberOfAllSeats+" ["+typeOfSeats[0]+"-"+numberOfSeats[0]+", "+
                typeOfSeats[typeOfSeats.length - 1]+"-"+numberOfSeats[numberOfSeats.length - 1]+"]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    static String[] autoTypeOfSeats(){
        String[] types = new String[2];
        types[0] = typesOfSeats[random(0,1)];
        types[1] = typesOfSeats[random(2,3)];
        return types;
    }

    int[] autoNumbersOfSeats(){
        int[] seats = new int[2];
        seats[0] = ((this.numberOfAllSeats / 10) * 7);
        seats[1] = this.numberOfAllSeats - seats[0];
        return seats;
    }
}
