package homework5.mobileConnection;

import homework5.mobileConnection.tariffs.City;
import homework5.mobileConnection.tariffs.Intercity;
import homework5.mobileConnection.tariffs.Maximum;
import homework5.mobileConnection.tariffs.Tariff;

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

    static Tariff[] list;

    static void printMenu(){
        String menu = "\n0. Вывести список всех тарифов\n"+
                "1. Сортировка тарифов на основе абонентской платы\n"+
                "2. Поиск тарифов в заданном диапазоне междугородних разговоров\n";
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
                printList();
            }break;
            case 1:{
                sortByInstallment();
            }break;
            case 2:{
                getByIntercity();
            }break;
        }
    }

    static String getClients (){
        int clients = 0;
        for (Tariff t:list){
            clients += t.getClients();
        }
        return "Общая численность клиентов = " + clients;
    }

    static void printList(){
        for (Tariff t:list){
            System.out.println(t);
        }
        System.out.println();
        System.out.println(getClients());
        printMenu();
    }

    static void sortByInstallment (){
        Arrays.sort(list,list[0].new TariffInstallmentComparator());
        printList();
    }

    static void getByIntercity(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона междугородних разговоров в минутах(от 1)\n");
            if (from < 1 || from >= 240){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from >= 240);
        do {
            to = readConsoleInt("\nВведите конец диапазона междугородних разговоров в минутах(до 240)\n");
            if (to <= from || to > 240){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >240);
        System.out.println("\nТарифы с временем междугородних разговоров от "+from+" до "+to+" минут\n");
        for (Tariff t:list){
            if (t.getIntercityMinutes() > from && t.getIntercityMinutes() < to){
                System.out.println(t);
            }
        }
        System.out.println();
    }

    static int sizeOfList(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество тарифов в списке: (от 5 до 25)\n");
            if (size < 5 || size > 25){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 5 || size > 25);
        return size;
    }

    static Tariff switchAddTariff(int choice){
        Tariff tariff = null;
        switch (choice){
            case 1:{
                tariff = new City();
            }break;
            case 2:{
                tariff = new Intercity();
            }break;
            case 3:{
                tariff = new Maximum();
            }break;
        }
        return tariff;
    }

    static void randomTariff(){
        sc = new Scanner(System.in);
        list = new Tariff[sizeOfList()];
        for (int i = 0;i < list.length;i++){
            list[i] = switchAddTariff(random(1,3));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomTariff();
    }
}
