package homework5.chiefCooker;

import homework5.chiefCooker.vegetables.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Vegetable[] salad;
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
        String menu = "\n0. Вывести информацию о салате\n"+
                "1. Сортировка по весу овощей в салате\n"+
                "2. Поиск овощей в салате соответствующему заданному диапазону калорийности\n";
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
                printSalad();
            }break;
            case 1:{
                sortByWeight();
            }break;
            case 2:{
                getByCalorificValue();
            }break;
        }
    }

    static void getByCalorificValue(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона\n");
            if (from < 1 || from > 200){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from > 200);
        do {
            to = readConsoleInt("\nВведите конец диапазона\n");
            if (to <= from || to > 200){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to > 200);
        System.out.println("\nОвощи имеющие калорийность от "+from+" % до "+to+" %\n");
        for (Vegetable v:salad){
            if (v.getCalorificValue() > from && v.getCalorificValue() < to){
                System.out.println(v);
            }
        }
        System.out.println();

    }

    static void sortByWeight(){
        Arrays.sort(salad,salad[0].new VegetableWeightComparator());
        printSalad();
    }

    static void printSalad(){
        System.out.println("\nСалат из "+salad.length+" овощей\n");
        for (Vegetable v:salad){
            System.out.println(v);
        }
        System.out.println("\nОбщая калорийность = "+getCalorificValue()+
                " кал. Общий вес = "+getWeight()+" грамм.\n");
        printMenu();
    }

    static int sizeOfSalad(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество овощей в салате: (от 3 до 6)\n");
            if (size < 3 || size > 6){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 3 || size > 6);
        return size;
    }

    static Vegetable switchAddVegetable(int choice){
        Vegetable vegetable = null;
        switch (choice){
            case 1:{
                vegetable = new Broccoli();
            }break;
            case 2:{
                vegetable = new Chilli();
            }break;
            case 3:{
                vegetable = new Cucumber();
            }break;
            case 4:{
                vegetable = new Eggplant();
            }break;
            case 5:{
                vegetable = new Rukkola();
            }break;
            case 6:{
                vegetable = new Tomato();
            }break;
        }
        return vegetable;
    }

    static void randomSalad(){
        sc = new Scanner(System.in);
        salad = new Vegetable[sizeOfSalad()];
        if (salad.length == 3){
            salad[0] = switchAddVegetable(random(1,2));
            salad[1] = switchAddVegetable(random(3,4));
            salad[2] = switchAddVegetable(random(5,6));
        }
        else if (salad.length == 4){
            salad[0] = switchAddVegetable(1);
            salad[1] = switchAddVegetable(random(2,3));
            salad[2] = switchAddVegetable(random(4,5));
            salad[3] = switchAddVegetable(6);
        }
        else if (salad.length > 4 || salad.length == 6){
            for (int i = 0;i < salad.length;i++){
                salad[i] = switchAddVegetable(i + 1);
            }
        }
        printMenu();
    }

    static int getCalorificValue(){
        int calorificValue = 0;
        for (Vegetable v:salad){
            calorificValue += v.getCalorificValue();
        }
        return calorificValue;
    }

    static int getWeight(){
        int weight = 0;
        for (Vegetable v:salad){
            weight += v.getWeight();
        }
        return weight;
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomSalad();
    }

}
