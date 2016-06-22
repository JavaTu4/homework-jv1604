package homework5.transport;

import homework5.transport.wagons.*;

import java.util.Arrays;
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

    static Wagon[] train;

    static void printMenu(){
        String menu = "\n0. Вывести список всех вагонов поезда\n"+
                "1. Сортировка вагонов на основе уровня комфорта\n"+
                "2. Поиск вагонов в заданном диапазоне числа пассажиров\n";
        int choice;
        do {
            choice = readConsoleInt("\nСделайте выбор\n"+menu);
            if (choice < 0 || choice > 2){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice > 2);
        switch (choice){
            case 0:{
                printTrain();
            }break;
            case 1:{
                sortByType();
            }break;
            case 2:{
                getByPassengers();
            }break;
        }
    }

    static int getPassengers(){
        int passengers = 0;
        for (Wagon w:train) {
            passengers += w.getPassengers();
        }
        return passengers;
    }
    static int getBaggage(){
        int baggage = 0;
        for (Wagon w:train) {
            baggage += w.getBaggage();
        }
        return baggage;
    }

    static void printTrain(){
        System.out.println("Поезд из " + train.length + " вагонов");
        for (Wagon w:train){
            System.out.println(w);
        }
        System.out.println();
        System.out.println("Общее число пассажиров " + getPassengers() + " чел.");
        System.out.println("Общее вес багажа " + getBaggage() + " кг.");
        printMenu();
    }

    static int sizeOfTrain(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество вагонов в поезде: (от 10 до 50)\n");
            if (size < 10 || size > 50){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 10 || size > 50);
        return size;
    }

    static Wagon switchAddWagon(int choice){
        Wagon wagon = null;
        switch (choice){
            case 1:{
                wagon = new Lux();
            }break;
            case 2:{
                wagon = new Coupe();
            }break;
            case 3:{
                wagon = new Econom();
            }break;
            case 4:{
                wagon = new Overall();
            }break;
        }
        return wagon;
    }

    static void randomTrain(){
        sc = new Scanner(System.in);
        train = new Wagon[sizeOfTrain()];
        for (int i = 0;i < train.length;i++){
            train[i] = switchAddWagon(random(1,4));
        }
        printMenu();
    }

    static void sortByType(){
        Arrays.sort(train,train[0].new WagonComfortLevelComparator());
        printTrain();
    }

    static void getByPassengers(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона числа мест (от 1)\n");
            if (from < 1 || from >= 81){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from >= 81);
        do {
            to = readConsoleInt("\nВведите конец диапазона числа мест (до 81)\n");
            if (to <= from || to >81){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >81);
        System.out.println("\nВагоны с числом мест от "+from+" до "+to+"\n");
        for (Wagon w:train){
            if (w.getPassengers() > from && w.getPassengers() < to){
                System.out.println(w);
            }
        }
        System.out.println();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomTrain();
    }
}
