package homework5.stones;

import homework5.stones.gems.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Gem[] necklace;
    public static int readConsoleInt(String message){
        System.out.println(message);
        int choice = 0;
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

    static void printMenu(){
        String menu = "\n0. Вывести информацию об ожерелье\n"+
                "1. Сортировка камней в ожерелье на основе ценности\n"+
                "2. Поиск камней в ожерелье соответствующему заданному диапазону прозрачности\n";
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
                printNecklace();
            }break;
            case 1:{
                sortByPrice();
            }break;
            case 2:{
                getByTransparence();
            }break;
        }
    }

    static void printNecklace(){
        System.out.println("\nОжерелье из "+necklace.length+" камней\n");
        for (Gem g:necklace){
            System.out.println(g);
        }
        System.out.println("\nОбщий вес = "+getWeight()+" карат, Общая стоимость = "+getPrice()+" $\n");
        printMenu();
    }

    static double getWeight(){
        double weight = 0;
        for (Gem g:necklace){
            weight += g.getWeight();
        }
        return weight;
    }

    static double getPrice(){
        double price = 0;
        for (Gem g:necklace){
            price += g.getPrice();
        }
        return price;
    }

    static void sortByPrice(){
        Arrays.sort(necklace,necklace[0].new GemPriceComparator());
        printNecklace();
    }

    static void getByTransparence(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона прозрачности в процентах (от 0)\n");
            if (from < 0 || from > 99){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 0 || from > 99);
        do {
            to = readConsoleInt("\nВведите конец диапазона прозрачности в процентах (до 100)\n");
            if (to <= from || to >100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >100);
        System.out.println("\nКамни с прозрачностью от "+from+" до "+to+" %\n");
        for (Gem g:necklace){
            if (g.getTransparence() > from && g.getTransparence() < to){
                System.out.println(g);
            }
        }
        System.out.println();

    }

    static int sizeOfNecklace(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество камней в ожерелье: (от 10 до 70)\n");
            if (size < 10 || size > 70){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 10 || size > 70);
        return size;
    }

    static Gem switchAddGem(int choice){
        Gem gem = null;
        switch (choice){
            case 1:{
                gem = new Alexandrite();
            }break;
            case 2:{
                gem = new Diamond();
            }break;
            case 3:{
                gem = new Emerald();
            }break;
            case 4:{
                gem = new Pearl();
            }break;
            case 5:{
                gem = new Ruby();
            }break;
            case 6:{
                gem = new Sapphire();
            }break;
        }
        return gem;
    }

    static void randomNecklace(){
        sc = new Scanner(System.in);
        necklace = new Gem[sizeOfNecklace()];
        for (int i = 0;i < necklace.length;i++){
            necklace[i] = switchAddGem(random(1,6));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomNecklace();
    }
}
