package hw4.bus;

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
            size = readConsoleInt("Введите размерность массива автобусов");
            if (size < 30) {
                System.out.println("Колличество автобусов не может быть меньше 30!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 30);
        Bus.buses = new Bus[size];
    }

    static void printMenu(){
        String menu = "0. Список всех автобусов\n"+
                "1. Список автобусов для заданного номера маршрута\n"+
                "2. Список автобусов, которые эксплуатируются больше заданного срока\n"+
                "3. Список автобусов, пробег у которых больше заданного расстояния\n";
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
                printAllBuses();
            }break;
            case 1:{
                getByRoute();
            }break;
            case 2:{
                getByExploitation();
            }break;
            case 3:{
                getByMileage();
            }break;
        }
    }

    static void printAllBuses(){
        for (Bus b:Bus.buses){
            System.out.println(b);
        }
        System.out.println();
        printMenu();
    }

    static void getByRoute(){
        for(int i = 0;i < Bus.routes.length;i++){
            System.out.println(i+". №"+Bus.routes[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("\nВведите номер маршрута");
            if (choice < 0 || choice >= Bus.routes.length){
                System.out.println("\nневерное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Bus.routes.length);
        System.out.println("Автобусы "+Bus.routes[choice]+" маршрута\n");
        for (Bus b:Bus.buses){
            if (b.getRoute().equals(Bus.routes[choice])){
                System.out.println(b);
            }
        }
        System.out.println();
    }

    static void getByExploitation(){
        int choice;
        do {
            choice = readConsoleInt("\nВведите количество лет эксплуатации\n");
            if (choice < 1 || choice >= 19){
                System.out.println("\nневерное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 || choice >= 19);
        System.out.println("Автобусы со сроком эксплуатации больше "+choice+" лет\n");
        for (Bus b:Bus.buses){
            if ((2016 - b.getYear()) > choice){
                System.out.println(b);
            }
        }
        System.out.println();
    }

    static void getByMileage(){
        int choice;
        do {
            choice = readConsoleInt("\nВведите расстояние в километрах\n");
            if (choice <= 0 || choice >= 100000){
                System.out.println("\nневерное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice <= 0 || choice >= 100000);
        System.out.println("Автобусы с пробегом больше "+choice+" километров\n");
        for (Bus b:Bus.buses){
            if (b.getMileage() > choice){
                System.out.println(b);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0;i < Bus.buses.length;i++){
            Bus.buses[i] = new Bus();
        }
        printMenu();
    }
}
