package hw4.phone;

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

    static {
        sc = new Scanner(System.in);
        int size;
        do {
            size = readConsoleInt("Введите размерность массива абонентов");
            if (size < 25) {
                System.out.println("Колличество абонентов не может быть меньше 25!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 25);
        Phone.phones = new Phone[size];
    }

    static void printMenu(){
        String menu = "0. Список всех абонентов\n"+
                "1. Список абонентов, у которых время внутригородских разговоров превышает заданное\n"+
                "2. Список абонентов которые пользовались междугородней связью\n"+
                "3. Список абонентов в алфавитном порядке\n";
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
                printAllPhones();
            }break;
            case 1:{
                getByCityCallTime();
            }break;
            case 2:{
                getByInterCityCall();
            }break;
            case 3:{
                phonesSort();
            }break;
        }
    }


    static void printAllPhones(){
        for (Phone p:Phone.phones){
            System.out.println(p);
        }
        System.out.println();
        printMenu();
    }

    static void getByCityCallTime(){
        int choice;
        do {
            choice = readConsoleInt("Введите время внутригородских разговоров");
            if (choice < 1 && choice >= 666){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 && choice >= 666);
        for (Phone p:Phone.phones){
            if (p.getCityCallsTime() > choice){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    static void getByInterCityCall(){
        for (Phone p:Phone.phones){
            if (p.getIntercityCallsTime() > 0){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    static void phonesSort(){
        Arrays.sort(Phone.phones,Phone.phones[0].new PhoneSurnameComparator());
        printAllPhones();
    }

    public static void main(String[] args) {
        for (int i = 0;i < Phone.phones.length;i++){
            Phone.phones[i] = new Phone(i + 1);
        }
        printMenu();
    }
}
