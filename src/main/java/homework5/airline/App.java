package homework5.airline;

import homework5.airline.aircrafts.*;

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

    static Aircraft[] airline;

    static void printMenu(){
        String menu = "\n0. Вывести список всех самолетов авиакомпании\n"+
                "1. Сортировка самолетов по дальности полёта\n"+
                "2. Поиск самолетов в заданном диапазоне потребления топлива\n";
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
                printAirline();
            }break;
            case 1:{
                sortByRange();
            }break;
            case 2:{
                getByConsumption();
            }break;
        }
    }

    static int getPassCapacity(){
        int passCapacity = 0;
        for (Aircraft a:airline){
            passCapacity += a.getPassengerCapacity();
        }
        return passCapacity;
    }

    static int getCarrCapacity(){
        int carrCapacity = 0;
        for (Aircraft a:airline){
            carrCapacity += a.getCarryingCapacity();
        }
        return carrCapacity;
    }

    static void printAirline(){
        System.out.println("Авиакомпания состоящая из " + airline.length + " самолетов\n");
        for (Aircraft a:airline){
            System.out.println(a);
        }
        System.out.println();
        System.out.println("Общая вместимость пассажиров = " + getPassCapacity());
        System.out.println("Общая грузоподъемность = " + getCarrCapacity() + " кг.");
        printMenu();
    }

    static void sortByRange(){
        Arrays.sort(airline,airline[0].new AircraftRangeComparator());
        printAirline();
    }

    static void getByConsumption(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона потребления горючего (кг/час, от 1000)\n");
            if (from < 1000 || from >= 20000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1000 || from >= 20000);
        do {
            to = readConsoleInt("\nВведите конец диапазона потребления горючего (кг/час, до 20000)\n");
            if (to <= from || to >20000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >20000);
        System.out.println("\nСамолеты с потреблением горючего от "+from+" до "+to+" кг/час\n");
        for (Aircraft a:airline){
            if (a.getFuelConsumption() > from && a.getFuelConsumption() < to){
                System.out.println(a);
            }
        }
        System.out.println();
    }

    static int sizeOfAirline(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество самолетов в авиакомпании: (от 10 до 100)\n");
            if (size < 10 || size > 100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 10 || size > 100);
        return size;
    }

    static Aircraft switchAddAircraft(int choice){
        Aircraft aircraft = null;
        switch (choice){
            case 1:{
                aircraft = new A_320();
            }break;
            case 2:{
                aircraft = new A_350();
            }break;
            case 3:{
                aircraft = new An_124();
            }break;
            case 4:{
                aircraft = new An_158();
            }break;
            case 5:{
                aircraft = new An_225();
            }break;
            case 6:{
                aircraft = new B737();
            }break;
            case 7:{
                aircraft = new B747();
            }break;
            case 8:{
                aircraft = new Il_76();
            }break;
            case 9:{
                aircraft = new Yak_242();
            }break;
        }
        return aircraft;
    }

    static void randomAirline(){
        sc = new Scanner(System.in);
        airline = new Aircraft[sizeOfAirline()];
        for (int i = 0;i < airline.length;i++){
            airline[i] = switchAddAircraft(random(1,9));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomAirline();
    }

}
