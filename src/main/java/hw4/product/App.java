package hw4.product;

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
            size = readConsoleInt("Введите размерность массива товаров");
            if (size < 25) {
                System.out.println("Колличество товаров не может быть меньше 25!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 25);
        Product.products = new Product[size];
    }

    static void printMenu(){
        String menu = "0. Список всех товаров\n"+
                "1. Список товаров для заданного наименования\n"+
                "2. Список товаров для заданного наименования, цена которых не превосходит заданную\n"+
                "3. Список товаров, срок хранения которых больше заданного\n";
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
                printAllProducts();
            }break;
            case 1:{
                getByName();
            }break;
            case 2:{
                getByNameAndPrice();
            }break;
            case 3:{
                getByStorageLife();
            }break;
        }
    }

    static void printAllProducts(){
        for (Product p:Product.products){
            System.out.println(p);
        }
        System.out.println();
        printMenu();
    }

    static void getByName(){
        for (int i = 0;i < Product.names.length;i++){
            System.out.println(i+". " +Product.names[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер наименования");
            if (choice < 0 || choice >= Product.names.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Product.names.length);
        System.out.println(Product.names[choice]+"\n");
        for (Product p:Product.products){
            if (p.getName().equals(Product.names[choice])){
                System.out.println(p);
            }
        }
        System.out.println();

    }

    static void getByNameAndPrice(){
        for (int i = 0;i < Product.names.length;i++){
            System.out.println(i+". " +Product.names[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер наименования");
            if (choice < 0 || choice >= Product.names.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 || choice >= Product.names.length);
        int choicePrice;
        do {
            choicePrice = readConsoleInt("Введите цену");
            if (choicePrice < 50 || choicePrice >=500){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choicePrice < 50 || choicePrice >=500);
        System.out.println(Product.names[choice]+" не дороже "+choicePrice+" грн.\n");
        for (Product p:Product.products){
            if (p.getName().equals(Product.names[choice]) && p.getPrice() < choicePrice){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    static void getByStorageLife(){
        int choice;
        do {
            choice = readConsoleInt("Введите срок хранения");
            if (choice < 5 || choice >= 180){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 5 || choice >= 180);
        System.out.println("Продукты срок хранения которых больше "+choice+" дней\n");
        for (Product p:Product.products){
            if (p.getStorageLife() > choice){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0;i < Product.products.length;i++){
            Product.products[i] = new Product(i + 1);
        }
        printMenu();
    }
}
