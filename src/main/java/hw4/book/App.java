package hw4.book;

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
            size = readConsoleInt("Введите размерность массива книг");
            if (size < 40) {
                System.out.println("Колличество книг не может быть меньше 40!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 40);
        Book.books = new Book[size];
    }

    public static void printMenu(){
        String menu = "0. Список всех книг\n"+
                "1. Список книг заданного автора\n"+
                "2. Список книг, выпущенным заданным издательством\n"+
                "3. Список книг, выпущенных после заданного года\n";
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
                printAllbooks();
            }break;
            case 1:{
                getByAuthor();
            }break;
            case 2:{
                getByPublishingHouse();
            }break;
            case 3:{
                getByYear();
            }break;
        }
    }


    static void printAllbooks(){
        for (Book b:Book.books){
            System.out.println(b);
        }
        System.out.println();
        printMenu();
    }

    static void getByAuthor(){
        for (int i = 0;i < Book.authors.length;i++){
            System.out.println(i+". " + Book.authors[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер автора");
            if (choice < 0 && choice >= Book.authors.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Book.authors.length);
        for (Book b : Book.books){
            if (b.getAuthor().equals(Book.authors[choice])){
                System.out.println(b);
            }
        }
        System.out.println();
    }

    static void getByPublishingHouse(){
        for (int i = 0;i < Book.publishingHouses.length;i++){
            System.out.println(i+". " + Book.publishingHouses[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер издательства");
            if (choice < 0 && choice >= Book.publishingHouses.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Book.publishingHouses.length);
        for (Book b : Book.books){
            if (b.getPublishingHouse().equals(Book.publishingHouses[choice])){
                System.out.println(b);
            }
        }
        System.out.println();
    }

    static void getByYear(){
        int year;
        do {
            year = readConsoleInt("Введите год ");
            if (year < 1900 || year > 2000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (year < 1900 || year > 2000);
        for (Book b:Book.books){
            if (b.getYearOfEdition() > year){
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < Book.books.length;i++){
            Book.books[i] = new Book(i + 1);
        }
        printMenu();

    }

}
