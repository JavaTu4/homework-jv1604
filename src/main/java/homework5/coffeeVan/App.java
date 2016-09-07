package homework5.coffeeVan;

import homework5.coffeeVan.coffee.Coffee;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    public static String[] sorts = {"Арабика", "Робуста", "Арабика+Робуста", "Либерика"};
    public static String[] states = {"Зерно", "Молотый", "В банке(р)", "В пакетике(р)"};

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

    public static double readConsoleDouble(String message){
        System.out.println(message);
        double choice;
        while (true){
            try{
                choice = Double.parseDouble(sc.next());
                break;
            }catch (NumberFormatException ex){
                System.out.println("Input Error! Try again.");
            }
        }
        return choice;
    }

    static Coffee[] van;

    static void printVan(Coffee[]array){
        for (Coffee c:array){
            System.out.println(c);
        }
        System.out.println();
        System.out.println(getVolumeWeightPriceAndAveragesVan(array));
        printMenu();
    }

    static void printMenu(){
        String menu = "\n0. Вывести список товаров из фургона\n"+
                "1. Сортировка кофе на основе соотношения цены и веса\n"+
                "2. Поиск тарифов в заданном диапазоне междугородних разговоров\n";
        int choice;
        do {
            choice = readConsoleInt("\nСделайте выбор\n"+menu);
            if (choice < 0 || choice > 3){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice > 3);
        switch (choice){
            case 0:{
                printVan(van);
            }break;
            case 1:{
                sortByRatio();
            }break;
            case 2:{
//                getByQuality();
            }break;
        }
    }

    static void sortByRatio(){
        Arrays.sort(van,van[0].new CoffeeRatioComparator());
        printVan(van);
    }

    static String getVolumeWeightPriceAndAveragesVan(Coffee[]array) {
        double volume = 0;
        double weight = 0;
        double price = 0;
        double[] average = new double[3];
        for (Coffee c : array) {
            volume += c.getVolume();
            weight += c.getWeight();
            price += c.getPrice();
        }
        average[0] = volume / array.length;
        average[1] = weight / array.length;
        average[2] = price / array.length;
        return "Колличество упаковок = " + array.length + "\n" +
                "Общий объем = " + (volume / 1000000) + " m3.\n" +
                "Общий вес = " + Math.rint(weight / 1000) + " kg.\n" +
                "Общая стоимость = " + Math.rint(price) + " $\n"+
                "Среднее: \n" +
                "\tОбъем = " + Math.rint(average[0]) + " cm3 \n" +
                "\tВес = " + Math.rint(average[1]) + " g \n" +
                "\tЦена = " + Math.rint(average[2]) + " $ ";
    }



    static double volumeOfVan(){
        sc = new Scanner(System.in);
        double volume;
        do {
            volume = readConsoleDouble("\nВведите объем фургона в м3: (от 1 до 20)\n");
            if (volume < 1 || volume > 20){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (volume < 1 || volume > 20);
        return volume * 1000000;
    }


    static void addToVan(){
        double volume = volumeOfVan();
        System.out.println(volume);
        int size = (int) volume / 11500;
        Coffee[]tmp = new Coffee[size];
        double vollVan = 0;
        for (int i = 0;i < tmp.length;i++){
            tmp[i] = new Coffee(sorts[random(0,(sorts.length - 1))],states[random(0,(states.length - 1))]);
            vollVan += tmp[i].getVolume();
            if (vollVan > volume - 23256){
                van = new Coffee[i];
                break;
            }
        }
        for (int j = 0;j < van.length;j++){
            van[j] = tmp[j];
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
       addToVan();
    }
}
