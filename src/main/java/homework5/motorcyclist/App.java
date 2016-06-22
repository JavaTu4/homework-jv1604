package homework5.motorcyclist;

import homework5.motorcyclist.ammunition.Ammunition;

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

    static Ammunition motorcyclist[];

    static void printMenu(){
        String menu = "\n0. Вывести список всей экипировки мотоциклиста\n"+
                "1. Сортировка экипировки на основе веса\n"+
                "2. Поиск экипировки в заданном диапазоне цены\n";
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
                printAllMotorcyclist();
            }break;
            case 1:{
                sortByWeight();
            }break;
            case 2:{
                getByPrice();
            }break;
        }
    }

    static int getPrice(){
        int price = 0;
        for (Ammunition a:motorcyclist) {
            price += a.getPrice();
        }
        return price;
    }
    
    static void printAllMotorcyclist(){
        for (Ammunition a:motorcyclist) {
            System.out.println(a);
        }
        System.out.println();
        System.out.println("Общая стоимость = " + getPrice() + "UAH ");
        printMenu();
    }

    static void sortByWeight(){
        Arrays.sort(motorcyclist,motorcyclist[0]. new AmmunitionWeightComparator());
        printAllMotorcyclist();
    }

    static void getByPrice(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона цены (от 1000)\n");
            if (from < 1000 || from >= 9999){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1000 || from >= 9999);
        do {
            to = readConsoleInt("\nВведите конец диапазона цены (до 10000)\n");
            if (to <= from || to >10000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >10000);
        System.out.println("\nЭкипировка с ценой от "+from+" до "+to+" UAH\n");
        for (Ammunition a:motorcyclist){
            if (a.getPrice() > from && a.getPrice() < to){
                System.out.println(a);
            }
        }
        System.out.println();
    }

    static void createMotorcyclist(){
        sc = new Scanner(System.in);
        motorcyclist = new Ammunition[Ammunition.types.length];
        for (int i = 0;i < motorcyclist.length; i++){
            motorcyclist[i] = new Ammunition(Ammunition.types[i]);
        }
        printMenu();
    }

    public static void main(String[] args) {
        createMotorcyclist();
    }
}
