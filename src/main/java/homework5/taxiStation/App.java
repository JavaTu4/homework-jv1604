package homework5.taxiStation;

import homework5.taxiStation.cars.*;

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

    static Car[] taxiStation;

    static void printMenu(){
        String menu = "\n0. Вывести список всех автомобилей таксопарка\n"+
                "1. Сортировка автомобилей по расходу топлива\n"+
                "2. Поиск автомобилей в заданном диапазоне скорости\n";
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
                printTaxiStation();
            }break;
            case 1:{
                sortByFuelConsumption();
            }break;
            case 2:{
                getBySpeed();
            }break;
        }
    }

    static void sortByFuelConsumption(){
        Arrays.sort(taxiStation,taxiStation[0].new CarFuelConsumptionComparator());
        printTaxiStation();
    }

    static void getBySpeed (){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона скорости (км/час, от 1)\n");
            if (from < 1 || from >= 200){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from >= 200);
        do {
            to = readConsoleInt("\nВведите конец диапазона скорости (км/час, до 201)\n");
            if (to <= from || to >201){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >201);
        System.out.println("\nАвтомобили со скоростью от "+from+" до "+to+" км/час\n");
        for (Car c:taxiStation){
            if (c.getMaxSpeed() > from && c.getMaxSpeed() < to){
                System.out.println(c);
            }
        }
        System.out.println();
    }

    static void printTaxiStation() {
        System.out.println("Таксопарк состоящий из " + taxiStation.length + " авто\n");
        for (Car c:taxiStation){
            System.out.println(c);
        }
        System.out.println();
        System.out.println("Стоимость таксопарка = " + getStationPrice() + " $");
        printMenu();
    }

    static int getStationPrice (){
        int price = 0;
        for (Car c:taxiStation){
             price += c.getPrice();
        }
        return price;
    }

    static int sizeOfTaxiStation(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество автомобилей в таксопарке: (от 50 до 500)\n");
            if (size < 50 || size > 500){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 50 || size > 500);
        return size;
    }

    static Car switchAddCar(int choice){
        Car car = null;
        switch (choice){
            case 1:{
                car = new L2101();
            }break;
            case 2:{
                car = new L2104();
            }break;
            case 3:{
                car = new L2106();
            }break;
            case 4:{
                car = new L2109();
            }break;
            case 5:{
                car = new L2110();
            }break;
            case 6:{
                car = new Kalina();
            }break;
            case 7:{
                car = new Priora();
            }break;
        }
        return car;
    }

    static void randomTaxiStation(){
        sc = new Scanner(System.in);
        taxiStation = new Car[sizeOfTaxiStation()];
        for (int i = 0;i < taxiStation.length;i++){
            taxiStation[i] = switchAddCar(random(1,7));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomTaxiStation();
    }
}
