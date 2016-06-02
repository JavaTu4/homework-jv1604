package homework5.newYearsGift;

import homework5.newYearsGift.sweets.PacketOfBiscuits;
import homework5.newYearsGift.sweets.StickOfChocolate;
import homework5.newYearsGift.sweets.Sweet;
import homework5.newYearsGift.sweets.candies.Candy;
import homework5.newYearsGift.sweets.candies.ChocolateCandy;
import homework5.newYearsGift.sweets.candies.ChocolateNutsCandy;
import homework5.newYearsGift.sweets.candies.Lollipop;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Candy[] candies;
    static Sweet[] sweets;
    static Object[] gift;

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
        String menu = "\n0. Вывести информацию о подарке\n"+
                "1. Сортировка по типу конфет\n"+
                "2. Поиск конфет в подарке соответствующему заданному диапазону содержания сахара\n";
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
                printGift();
            }break;
            case 1:{
                sortByType();
            }break;
            case 2:{
                getBySugar();
            }break;
        }
    }

    static void printGift(){
        System.out.println("\nПодарок состоящий из: "+gift.length+" сладостей\n");
        for (Object o:gift){
            System.out.println(o);
        }
        System.out.println("\nВес подарка: = "+getWeight()+" г.\n");

        printMenu();
    }

    static int getWeight(){
        int weight = 0;
        for (Sweet s:sweets){
            weight += s.getWeight();
        }
        return weight;
    }

    static void sortByType(){
        Arrays.sort(candies,candies[0].new SweetTypeComparator());
        System.out.println("\nПодарок отсортированный по типу сладостей\n");
        for (int k = 2;k < gift.length;k++){
            gift[k] = candies[k - 2];
        }
        printGift();
    }

    static void getBySugar(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона (от 1 до 13)\n");
            if (from < 1 || from >= 14){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from >= 14);
        do {
            to = readConsoleInt("\nВведите конец диапазона (максимум 15)\n");
            if (to <= from || to > 15){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to > 15);
        System.out.println("\nКонфеты имеющие содержание сахара от "+from+" % до "+to+" %\n");
        for (Candy c:candies){
            if (c.getSugar() > from && c.getSugar() < to){
                System.out.println(c);
            }
        }
        System.out.println();
    }

    static int sizeOfGift(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество сладостей в подарке: (от 20 до 100)\n");
            if (size < 20 || size > 100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 20 || size > 100);
        return size;
    }

    static Candy switchAddCandies(int choice){
        Candy candy = null;
        switch (choice){
            case 1:{
                candy = new ChocolateCandy();
            }break;
            case 2:{
                candy = new ChocolateNutsCandy();
            }break;
            case 3:{
                candy = new Lollipop();
            }break;
        }
        return candy;
    }

    static void randomGift(){
        sc = new Scanner(System.in);

        sweets = new Sweet[sizeOfGift()];
        sweets[0] = new StickOfChocolate();
        sweets[1] = new PacketOfBiscuits();
        candies = new Candy[sweets.length - 2];
        for (int i = 0;i < candies.length;i++){
            candies[i] = switchAddCandies(random(1,3));
        }
        for (int j = 2;j < sweets.length;j++){
            sweets[j] = candies[j - 2];
        }
        gift = new Object[sweets.length];
        for (int k = 0;k < gift.length;k++){
            gift[k] = sweets[k];
        }

        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomGift();
    }

}
