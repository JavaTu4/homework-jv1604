package hw4.house;

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
            size = readConsoleInt("Введите размерность массива квартир");
            if (size < 25) {
                System.out.println("Колличество квартир не может быть меньше 25!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 25);
        House.houses = new House[size];
    }

    static void printMenu(){
        String menu = "0. Список всех квартир\n"+
                "1. Список квартир, имеющих заданное число комнат\n"+
                "2. Список квартир имеющих заданное число комнат и расположенных на этаже,\n"+
                "который находится в заданном промежутке\n"+
                "3. Список квартир, имеющих площадь, превосходящую заданную\n";
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
                printAllHouses();
            }break;
            case 1:{
                getByRooms();
            }break;
            case 2:{
                getByRoomsAndLevelsInterval();
            }break;
            case 3:{
                getBySquare();
            }break;
        }
    }

    static void printAllHouses(){
        for (House h:House.houses){
            System.out.println(h);
        }
        System.out.println();
        printMenu();
    }

    static void getByRooms(){
        int choice;
        do {
            choice = readConsoleInt("Введите число комнат");
            if (choice < 1 && choice > 5){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 && choice > 5);
        System.out.println("Квартиры с "+choice+" комнатами\n");
        for (House h:House.houses){
            if (h.getNumberOfRooms() == choice){
                System.out.println(h);
            }
        }
        System.out.println();
    }

    static void getByRoomsAndLevelsInterval(){
        int choice;
        do {
            choice = readConsoleInt("Введите число комнат");
            if (choice < 1 && choice > 5){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 1 && choice > 5);
        int from;
        int to;
        do {
            from = readConsoleInt("Введите начало интервала");
            if (from < 1 || from >= 24){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 1 || from >= 24);
        do {
            to = readConsoleInt("Введите конец интервала");
            if (to <= from || to > 24 || to == from + 1){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to > 24 || to == from + 1);
        for (House h:House.houses){
            if (h.getLevel() >= from && h.getLevel() <= to && h.getNumberOfRooms() == choice){
                System.out.println(h);
            }
        }
        System.out.println();
    }

    static void getBySquare(){
        int choice;
        do {
            choice = readConsoleInt("Введите площадь");
            if (choice < 25 || choice > 200){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 25 || choice > 200);
        for (House h:House.houses){
            if (h.getSquare() > choice){
                System.out.println(h);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0;i < House.houses.length;i++){
            House.houses[i] = new House(i + 1);
        }
        printMenu();
    }
}
