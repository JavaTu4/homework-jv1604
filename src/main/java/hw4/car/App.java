package hw4.car;

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
            size = readConsoleInt("Введите размерность массива автомобилей");
            if (size < 25) {
                System.out.println("Колличество автомобилей не может быть меньше 25!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 25);
        Car.cars = new Car[size];
    }

    static void printMenu(){
        String menu = "0. Список всех автомобилей\n"+
                "1. Список автомобилей заданной марки\n"+
                "2. Список автомобилей заданной модели, которые эксплуатируются больше \n"+
                "заданного количества лет\n"+
                "3. Список автомобилей заданного года выпуска, цена которых выше указанной\n";
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
                printAllCars();
            }break;
            case 1:{
                getByManufacturer();
            }break;
            case 2:{
                getByModelAndYear();
            }break;
            case 3:{
                getByYearAndPrice();
            }break;
        }
    }

    static void printAllCars(){
        for (Car c:Car.cars){
            System.out.println(c);
        }
        System.out.println();
        printMenu();
    }

    static void getByManufacturer(){
        for (int i = 0;i < Car.manufacturers.length;i++){
            System.out.println(i+". "+ Car.manufacturers[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер модели");
            if (choice < 0 && choice >= Car.manufacturers.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Car.manufacturers.length);
        System.out.println("Автомобили марки : "+Car.manufacturers[choice]+"\n");
        for (Car c:Car.cars) {
            if (c.getManufacturer().equals(Car.manufacturers[choice])){
                System.out.println(c);
            }
        }
        System.out.println();
    }

    static void getByModelAndYear(){
        for (int i = 0;i < Car.models.length;i++){
            System.out.println(i+". "+ Car.models[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер модели");
            if (choice < 0 && choice >= Car.models.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Car.models.length);
        int choiceYear;
        do {
            choiceYear = readConsoleInt("Вветите количество лет эксплуатации");
            if (choiceYear < 1 || choiceYear > 20){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choiceYear < 1 || choiceYear > 20);
        System.out.println("Автомобили модели : "+Car.models[choice]+" со сроком эксплуатации больше "+choiceYear+" лет\n");
        for (Car c:Car.cars){
            if (c.getModel().equals(Car.models[choice]) && (2016 - c.getYearOfManufacture()) > choiceYear){
                System.out.println(c);
            }
        }
        System.out.println();
    }

    static void getByYearAndPrice(){
        int choice;
        do {
            choice = readConsoleInt("Введите год выпуска");
            if (choice < 1995 || choice > 2015){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1995 || choice > 2015);
        int choicePrice;
        do {
            choicePrice = readConsoleInt("Введите цену");
            if (choicePrice < 1000 || choicePrice >= 9999){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choicePrice < 1000 || choicePrice >= 9999);
        System.out.println("Автомобили "+choice+" года выпуска"+" с ценой выше чем "+choicePrice+" $\n");
        for (Car c:Car.cars){
            if (c.getYearOfManufacture() == choice && c.getPrice() > choicePrice){
                System.out.println(c);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0;i < Car.cars.length;i++){
            Car.cars[i] = new Car(i + 1);
        }
        printMenu();
    }
}
