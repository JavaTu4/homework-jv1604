package homework5.homeAppliances;

import homework5.homeAppliances.appliances.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Appliance[] appliances;
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
        String menu = "\n0. Вывести список всех электроприборов\n"+
                "1. Вывести список включенных электроприборов\n"+
                "2. Соротировка электроприборов на основе мощности\n"+
                "3. Поиск электроприбора соответствующего заданному диапазону мощности\n";
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
                printAllAppliances();
            }break;
            case 1:{
                printOfAllPowerOn();
            }break;
            case 2:{
                sortByPower();
            }break;
            case 3:{
                getByPower();
            }break;
        }
    }

    static void printAllAppliances(){
        System.out.println("\nСписок всех электроприборов:\n");
        for (Appliance a:appliances){
            System.out.println(a);
        }
        System.out.println();
        printMenu();
    }

    static void printOfAllPowerOn(){
        System.out.println("\nПотребляемая мощность включенных электроприборов = "+getPower()+" Вт*ч\n");
        for (Appliance a:appliances){
            if (a.getStatus()){
                System.out.println(a);
            }
        }
        System.out.println();
        printMenu();
    }

    static void sortByPower(){
        Arrays.sort(appliances,appliances[0].new AppliancePowerComparator());
        printAllAppliances();
    }

    static void getByPower(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона: (от 59)\n");
            if (from < 59 || from >= 5000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 59 || from >= 5000);
        do {
            to = readConsoleInt("\nВведите конец диапазона: (до 5001)\n");
            if (to <= from || to > 5001){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to > 5001);
        System.out.println("\nСписок электроприборов с потребляемой мощностью в диапазоне от "+
                from+" Вт*ч, до "+to+" Вт*ч\n");
        for (Appliance a:appliances){
            if (a.getPowerInHour() > from && a.getPowerInHour() < to){
                System.out.println(a);
            }
        }
        System.out.println();
    }

    static int getPower(){
        int power = 0;
        for (Appliance a:appliances){
            if (a.getStatus()){
                power += a.getPowerInHour();
            }
        }
        return power;
    }

    static int sizeOfAppliances(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество электроприборов в квартире: (от 20 до 100)\n");
            if (size < 20 || size > 100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 20 || size > 100);
        return size;
    }

    static Appliance switchAddAppliance(int choice){
        Appliance appliance = null;
        switch (choice){
            case 1:{
                appliance = new AirCondicioner();
            }break;
            case 2:{
                appliance = new Computer();
            }break;
            case 3:{
                appliance = new Dishwasher();
            }break;
            case 4:{
                appliance = new Flatiron();
            }break;
            case 5:{
                appliance = new Lightbulb();
            }break;
            case 6:{
                appliance = new Microwave();
            }break;
            case 7:{
                appliance = new Refrigerator();
            }break;
            case 8:{
                appliance = new Toster();
            }break;
            case 9:{
                appliance = new Tv();
            }break;
            case 10:{
                appliance = new Washer();
            }break;
        }
        return appliance;
    }

    static void randomAppliances(){
        sc = new Scanner(System.in);
        appliances = new Appliance[sizeOfAppliances()];
        for (int i = 0;i < appliances.length;i++){
            appliances[i] = switchAddAppliance(random(1,10));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomAppliances();
    }


}
