package hw4.airline;

/**
 * Created by root;
 */
public class Airline {
    private String destination;
    private String flightNumber;
    private String type;
    private String depTime;
    private String dayOfWeek;

    static Airline[]airlines;

    static String[] destinations = {" Аэропорт Хитроу"," Международный аэропорт имени Шарля де Голля"," Аэропорт Франкфурт",
            " Амстердамский аэропорт Схипхол", " Аэропорт Мадрид-Барахас", " Международный аэропорт имени Ататюрка", " Аэропорт Мюнхен",
            " Международный аэропорт имени Леонардо да Винчи", " Международный аэропорт Барселона", " Аэропорт Гатвик",
            " Международный аэропорт Шереметьево"};
    static String[] types = {"McDonnell-Douglas MD-11", "Airbus 757", "Airbus  A320", "Boeing 767", "Boeing 737 NG", "Boeing 747", "Airbus A330", "Airbus A340", "Boeing 777"};
    static String[] week = {"Понедельник ", "Вторник ", "Среда ", "Четверг ", "Пятница ", "Суббота ", "Воскресенье "};

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

    public String getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getDepTime() {
        return depTime;
    }
    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Airline() {
        this.destination = destinations[random(0,(destinations.length - 1))];
        this.flightNumber = autoFlightNumber();
        this.type = types[random(0,(types.length - 1))];
        this.depTime = hours[random(0,(hours.length - 1))]+":"+random(0,5)+random(0,9);
        this.dayOfWeek = week[random(0,(week.length - 1))];
    }

    @Override
    public String toString() {
        return "[ Направление: "+destination+"] [Рейс № ("+flightNumber+")] [Время вылета: "+depTime+"] ["+dayOfWeek+"] ["+type+"]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }
    static String letters = "QWERTYUIOPASDFGHJKLZXCVBNM";

    static String autoFlightNumber() {
        String[] letter = new String[letters.length()];
        for (int i = 0; i < letters.length() - 1; i++) {
            letter[i] = letters.substring(i,(2 + i));
        }
        return letter[random(0,(letter.length - 1))]+letter[random(0,(letter.length - 1))] +" "+ random(100,999);
    }


}
