package hw4.train;

import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;

    public static int readConsoleInt(String message){
        System.out.println(message);
        int choice;
        while (true){
            try{
                choice = Integer.parseInt(sc.next());
                break;
            }catch (NumberFormatException ex){
                System.out.println("Input Error! Try again.");
            }
        }
        return choice;
    }

    static {
        sc = new Scanner(System.in);
        int size;
        do {
            size = readConsoleInt("Введите размерность массива поездов");
            if (size < 15) {
                System.out.println("Колличество поездов не может быть меньше 15!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 15);
        Train.trains = new Train[size];
    }

    static void printMenu(){
        String menu = "0. Список всех поездов\n"+
                "1. Список поездов, следующих до заданного пункта назначения\n"+
                "2. Список поездов, следующих до заданного пункта назначения\n"+
                "\tи отправляющихся после заданного времени\n"+
                "3. Список поездов, следующих до заданного пункта назначения\n"+
                "\tи имеющих общие места\n";
        int choice;
        do {
            choice = readConsoleInt("Сделайте выбор: \n"+menu);
            if (choice < 0 && choice > 3){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice > 3);
        switch (choice){
            case 0:{
                printAllTrains();
            }break;
            case 1:{
                getByDestination();
            }break;
            case 2:{
                getByDestinationAndTime();
            }break;
            case 3:{
                getByDestinationAndOverallSeats();
            }break;
        }
    }

    static void printAllTrains(){
        for (Train t:Train.trains){
            System.out.println(t);
        }
        System.out.println();
        printMenu();
    }

    static void getByDestination(){
        for (int i = 0;i < Train.destinations.length;i++){
            System.out.println(i+". "+Train.destinations[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер пункта назначения");
            if (choice < 0 || choice >= Train.destinations.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Train.destinations.length);
        System.out.println("Поезда следующие до "+Train.destinations[choice]+"\n");
        for (Train t:Train.trains){
            if (t.getDestination().equals(Train.destinations[choice])){
                System.out.println(t);
            }
        }
        System.out.println();
        printMenu();
    }

    static void getByDestinationAndTime(){
        for (int i = 0;i < Train.destinations.length;i++){
            System.out.println(i+". "+Train.destinations[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер пункта назначения");
            if (choice < 0 || choice >= Train.destinations.length){
                System.out.println("\nневерное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Train.destinations.length);
        int choiceHours;
        do {
            choiceHours = readConsoleInt("\nВведите часы (от 0 до 23)");
            if (choiceHours < 0 || choiceHours >= 23){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choiceHours < 0 || choiceHours >= 23);
        int choiceMinutes;
        do {
            choiceMinutes = readConsoleInt("\nВведите минуты (от 0 до 59)");
            if (choiceMinutes < 0 || choiceMinutes >= 59){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choiceMinutes < 0 || choiceMinutes >= 59);
        System.out.println("Поезда следующие до "+Train.destinations[choice]+" отправляющиеся позже "+choiceHours+":" +
        choiceMinutes+"\n");
        for (Train t:Train.trains){
            if (t.getDestination().equals(Train.destinations[choice]) &&
                    Integer.parseInt(t.getTimeOfDeparture().substring(0,2)) == choiceHours &&
                    Integer.parseInt(t.getTimeOfDeparture().substring(3)) > choiceMinutes){
                System.out.println(t);
            }
            if (t.getDestination().equals(Train.destinations[choice]) &&
                    Integer.parseInt(t.getTimeOfDeparture().substring(0,2)) > choiceHours){
                System.out.println(t);
            }
        }
        System.out.println();
    }

    static void getByDestinationAndOverallSeats(){
        for (int i = 0;i < Train.destinations.length;i++){
            System.out.println(i+". "+Train.destinations[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер пункта назначения");
            if (choice < 0 || choice >= Train.destinations.length){
                System.out.println("\nневерное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Train.destinations.length);
        System.out.println("Поезда следующие до "+Train.destinations[choice]+" имеющие общие места\n");
        for(Train t:Train.trains){
            for (String s:t.getTypeOfSeats()) {
                if (t.getDestination().equals(Train.destinations[choice]) && s.equals(Train.typesOfSeats[0])){
                    System.out.println(t);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0;i < Train.trains.length;i++){
            Train.trains[i] = new Train();
        }
        printMenu();

    }
}
