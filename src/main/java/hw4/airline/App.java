package hw4.airline;

import java.util.Scanner;

/**
 * Created by root;
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

    static  void addAir(){
        sc = new Scanner(System.in);
        Airline.airlines = new Airline[0];
        int size;
        do {
            size = readConsoleInt("Введите размерность массива самолётов");
            if (size < 30) {
                System.out.println("Колличество самолётов не может быть меньше 30!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 30);
        Airline.airlines = new Airline[size];
        for (int i = 0;i < Airline.airlines.length;i++){
            Airline.airlines[i] = new Airline();
        }
        printMenu();
    }

    static void printMenu(){
        String menu = "0. Список всех рейсов\n"+
                "1. Список рейсов, следующих до заданного пункта назначения\n"+
                "2. Список рейсов для заданного дня недели\n"+
                "3. Список рейсов для заданного дня недели, время вылета которых позже заданного\n"+
                "4. Создать другой массив рейсов\n"+
                "5. = Выход\n";
        int choice;
        do {
            choice = readConsoleInt("Сделайте выбор: \n"+menu);
            if (choice < 0 || choice > 5){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice > 5);
        switch (choice){
            case 0:{
                printAllAirlines();
            }break;
            case 1:{
                getByDestination();
            }break;
            case 2:{
                getByDay();
            }break;
            case 3:{
                getByDayAndTime();
            }break;
            case 4:{
                Airline.airlines = null;
                addAir();
            }break;
            case 5:{
                return;
            }
        }
    }

    static void printAllAirlines(){
        for (Airline a:Airline.airlines){
            System.out.println(a);
        }
        System.out.println();
        printMenu();
    }

    static void getByDestination() {
        for (int i = 0; i < Airline.destinations.length; i++) {
            System.out.println(i + ". " + Airline.destinations[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер пункта назначения");
            if (choice < 0 || choice >= Airline.destinations.length) {
                System.out.println("неверное значение. \n" +
                        "повторите ввод данных");
            }
        } while (choice < 0 || choice >= Airline.destinations.length);
        System.out.println("Самолёты летящие В " + Airline.destinations[choice] + "\n");
        for (Airline a : Airline.airlines) {
            if (a.getDestination().equals(Airline.destinations[choice])) {
                System.out.println(a);
            }
        }
        System.out.println();
        printMenu();
    }

    static void getByDay(){
        for (int i = 0;i < Airline.week.length;i++){
            System.out.println(i + ". " + Airline.week[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер дня недели\n");
            if (choice < 0 || choice >= Airline.week.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Airline.week.length);
        System.out.println("Самолёты летящие В "+ Airline.week[choice]+"\n");
        for (Airline a:Airline.airlines){
            if (a.getDayOfWeek().equals(Airline.week[choice])){
                System.out.println(a);
            }
        }
        System.out.println();
        printMenu();
    }

    static void getByDayAndTime() {
        for (int i = 0; i < Airline.week.length; i++) {
            System.out.println(i + ". " + Airline.week[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер дня недели\n");
            if (choice < 0 || choice >= Airline.week.length) {
                System.out.println("неверное значение. \n" +
                        "повторите ввод данных");
            }
        } while (choice < 0 || choice >= Airline.week.length);
        System.out.println("Самолёты летящие В " + Airline.week[choice] + "\n");
        for (Airline a : Airline.airlines) {
            if (a.getDayOfWeek().equals(Airline.week[choice])) {
                System.out.println(a);
            }
        }
        System.out.println();
        int choiceHours;
        do {
            choiceHours = readConsoleInt("\nВведите часы (от 0 до 23)");
            if (choiceHours < 0 || choiceHours >= 23) {
                System.out.println("неверное значение. \n" +
                        "повторите ввод данных");
            }
        } while (choiceHours < 0 || choiceHours >= 23);
        int choiceMinutes;
        do {
            choiceMinutes = readConsoleInt("\nВведите минуты (от 0 до 59)");
            if (choiceMinutes < 0 || choiceMinutes >= 59) {
                System.out.println("неверное значение. \n" +
                        "повторите ввод данных");
            }
        } while (choiceMinutes < 0 || choiceMinutes >= 59);
        System.out.println("День недели " + Airline.week[choice] + " Время вылета после " + choiceHours + ":" + choiceMinutes + "\n");
        for (Airline a : Airline.airlines) {
            try {
                if (a.getDayOfWeek().equals(Airline.week[choice]) &&
                        Integer.parseInt(a.getDepTime().substring(0, 2)) == choiceHours &&
                        Integer.parseInt(a.getDepTime().substring(3)) > choiceMinutes) {
                    System.out.println(a);
                }
            }catch(NumberFormatException ex){
            getByDayAndTime();
            }
            if (a.getDayOfWeek().equals(Airline.week[choice]) &&
                    Integer.parseInt(a.getDepTime().substring(0, 2)) > choiceHours) {
                System.out.println(a);
            }
    }
        System.out.println();
        printMenu();
    }

    public static void main(String[] args) {
        addAir();
    }
}
