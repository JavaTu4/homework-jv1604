package homework5.florist;

import homework5.florist.flowers.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Flower[] flowers;
    static Accessory[] accessories;
    static Object[] bouquet;

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

    static void printBouquet(){
        for (Object o:bouquet) {
            System.out.println(o);
        }
        System.out.println("[Цена букета "+getPrice()+" грн., средняя свежесть "+(int)getAverageFreshness()+
                " %, средняя длинна стебля "+(int)getAverageStemLenght()+" cm.]\n");
        printMenu();
    }
    static void sortByFreshness(){
        Arrays.sort(flowers,flowers[0].new FreshnessComparator());
        System.out.println("Букет отсортированнй по свежести цветов\n");
        for (int j = 0;j < flowers.length;j++){
            bouquet[j] = flowers[j];
        }
        int a = 0;
        for (int k = bouquet.length - accessories.length;k < bouquet.length;k++){
            bouquet[k] = accessories[a];
            a++;
        }
        printBouquet();
    }
    static void getByStemLenght(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона в см. (минимум 10)\n");
            if (from < 10 || from >= 30){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 10 || from >= 30);
        do {
            to = readConsoleInt("\nВведите конец диапазона в см. (максимум 30)\n");
            if (to <= from || to > 30){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to > 30);
        for (Flower f:flowers) {
            if (f.getStemLenght() > from && f.getStemLenght() < to){
                System.out.println(f);
            }
        }
        System.out.println();
    }

    static void printMenu(){
        String menu = "\n0. Вывести информацию о букете\n"+
                "1. Сортировка по уровню свежести\n"+
                "2. Поиск цветка в букете соответствующему заданному диапазону длинн стеблей\n";
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
                printBouquet();
            }break;
            case 1:{
                sortByFreshness();
            }break;
            case 2:{
                getByStemLenght();
            }break;
        }
    }
    static void printCreateMenu(){
        sc = new Scanner(System.in);
        String menu = "\nВыберите способ создания букета:\n"+
                "1. Вручную\n"+
                "2. Случайная генерация букета с заданным количеством цветов и аксессуаров\n";
        int choice;
        do {
            choice = readConsoleInt("\nСделайте выбор\n"+menu);
            if (choice < 1 || choice > 2){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 || choice > 2);
        switch (choice){
            case 1:{
                bouquet = manuallyBouquet();
            }break;
            case 2:{
                bouquet = randomBouquet();
            }break;
        }
        printMenu();
    }
    static String printMenuOfAddAccesory(){
        String menu = null;
        for (int i = 0;i < Accessory.getTypes().length;i++){
            menu += (i + 1) + " Добавить к букету "+Accessory.getTypes()[i]+"\n";
        }
        menu = menu.substring(4);
        return "\n"+menu;
    }
    static String printMenuOfManuallyAddFlowers(){
        String menu = "1. Букет из роз\n"+
                "2. Букет из Тюльпанов\n"+
                "3. Букет из Ромашек\n"+
                "4. Букет из Хризантем\n";
        return "\n"+menu;
    }
    static String printMenuOfManuallyAddFlower(){
        String menu = "1. Добавить к букету Розу\n"+
                "2. Добавить к букету Тюльпан\n"+
                "3. Добавить к букету Ромашку\n"+
                "4. Добавить к букету Хризантему\n";
        return "\n"+menu;
    }
    static String printMenuOfRandomAddFlower(){
        String menu = "1. Сгенерировать случайный букет из "+flowers.length+" цветов\n"+
                "2. Случайный букет из одинаковых цветов\n";
        return "\n"+menu;
    }

    static Object[] randomBouquet(){
        flowers = new Flower[flowersSize()];
        accessories = new Accessory[accesoriesSize()];
        Object[] bouquet = new Object[flowers.length + accessories.length];
        int choice = readConsoleInt("\nСделайте выбор\n"+printMenuOfRandomAddFlower());
        switch (choice){
            case 1:{
                for (int i = 0; i <flowers.length;i++) {
                    flowers[i] = switchManuallyAddFlower(random(1,4));
                }
            }break;
            case 2:{
                int choiceType;
                do {
                    choiceType = readConsoleInt("\nСделайте выбор\n"+printMenuOfManuallyAddFlowers());
                    if (choiceType < 1 || choiceType > 4){
                        System.out.println("неверное значение. \n"+
                                "повторите ввод данных");
                    }
                }while (choiceType < 1 || choiceType > 4);
                flowers = switchManuallyAddFlowers(choiceType);
            }break;
        }
        for (int i = 0;i < accessories.length;i++){
            accessories[i] = switchManuallyAddAccesory(random(1,4));
        }
        for (int j = 0;j < flowers.length;j++){
            bouquet[j] = flowers[j];
        }
        int a = 0;
        for (int k = bouquet.length - accessories.length;k < bouquet.length;k++){
            bouquet[k] = accessories[a];
            a++;
        }
        return bouquet;

    }
    static Object[] manuallyBouquet(){
        flowers = addFlowers();
        accessories = addAccesories();
        Object[] bouquet = new Object[flowers.length + accessories.length];
        for (int j = 0;j < flowers.length;j++){
            bouquet[j] = flowers[j];
        }
        int a = 0;
        for (int k = bouquet.length - accessories.length;k < bouquet.length;k++){
            bouquet[k] = accessories[a];
            a++;
        }
        return bouquet;
    }

    static Accessory switchManuallyAddAccesory(int choice){
        Accessory accesory = null;
        if (choice > 0 && choice < 5) {
                switch (choice) {
                    case 1: {
                        accesory = new Accessory(Accessory.getTypes()[choice - 1],random(75, 150));
                    }break;
                    case 2: {
                        accesory = new Accessory(Accessory.getTypes()[choice - 1],random(5, 15));
                    }break;
                    case 3: {
                        accesory = new Accessory(Accessory.getTypes()[choice - 1],random(3, 10));
                    }break;
                    case 4: {
                        accesory = new Accessory(Accessory.getTypes()[choice - 1],random(2,9));
                    }break;
                }
        }
        else {
            System.out.println("неверное значение. \n");
        }
        return accesory;
    }
    static Flower switchManuallyAddFlower(int choice){
        Flower flower = null;
        if (choice > 0 && choice <= 4) {
            switch (choice) {
                case 1: {
                    flower = new Rose();
                }
                break;
                case 2: {
                    flower = new Tulip();
                }
                break;
                case 3: {
                    flower = new Chamomile();
                }
                break;
                case 4: {
                    flower = new GoldenDaisy();
                }
                break;
            }
        }
        else {
            System.out.println("неверное значение. \n"+
                    "повторите ввод данных");
        }
        return flower;
    }
    static Flower[] switchManuallyAddFlowers(int choice){
        Flower[]flow = new Flower[flowers.length];
        if (choice > 0 && choice < 5){
            switch (choice){
                case 1:{
                    for (int i = 0; i <flow.length;i++){
                        flow[i] = new Rose();
                    }
                }break;
                case 2:{
                    for (int i = 0; i <flow.length;i++){
                        flow[i] = new Tulip();
                    }
                }break;
                case 3:{
                    for (int i = 0; i <flow.length;i++){
                        flow[i] = new Chamomile();
                    }
                }break;
                case 4:{
                    for (int i = 0; i <flow.length;i++){
                        flow[i] = new GoldenDaisy();
                    }
                }break;
            }
        }
        else {
            System.out.println("неверное значение. \n"+
                    "повторите ввод данных");
        }
        return flow;
    }

    static Accessory[] addAccesories(){
        accessories = new Accessory[accesoriesSize()];
        int choice;
        for (int i = 0;i < accessories.length;i++){
            do {
                choice = readConsoleInt("\nСделайте выбор\n"+printMenuOfAddAccesory());
                if (choice < 1 || choice > 4){
                    System.out.println("неверное значение. \n"+
                            "повторите ввод данных");
                }
            }while (choice < 1 || choice > 4);
            accessories[i] = switchManuallyAddAccesory(choice);
        }
        return accessories;
    }
    static Flower[] addFlowers(){
        flowers = new Flower[flowersSize()];
        int choice;
        for (int i = 0;i < flowers.length;i++) {
            do {
                choice = readConsoleInt("\nСделайте выбор:\n" + printMenuOfManuallyAddFlower());
                if (choice < 1 || choice > 4) {
                    System.out.println("неверное значение. \n" +
                            "повторите ввод данных");
                }
            } while (choice < 1 || choice > 4);
            flowers[i] = switchManuallyAddFlower(choice);
        }
        return flowers;
    }

    static int flowersSize(){
        int choice;
        do {
            choice = readConsoleInt("\nВведите колличество цветов в букете (от 5 до 150)\n");
            if (choice < 5 || choice > 150){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 5 || choice > 150);
        return choice;
    }
    static int accesoriesSize(){
        int choice;
        do {
            choice = readConsoleInt("\nВведите колличество аксессуаров добавляемое к букету (от 1 до 4)\n");
            if (choice < 1 || choice > 4){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 || choice > 4);
        return choice;
    }

    static int getPrice(){
        int price = 0;
        for (Flower f:flowers){
            price += f.getPrice();
        }
        for (Accessory a:accessories){
            price += a.getPrice();
        }
        return price;
    }
    static double getAverageStemLenght(){
        double average = 0;
        for (Flower f:flowers){
            average += f.getStemLenght();
        }
        average = average / flowers.length;
        return average;
    }
    static double getAverageFreshness(){
        double average = 0;
        for (Flower f:flowers){
            average += f.getFreshness();
        }
        average = average / flowers.length;
        return average;
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        printCreateMenu();
    }

}
