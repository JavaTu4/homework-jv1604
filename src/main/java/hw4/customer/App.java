package hw4.customer;
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

    public static long readConsoleLong(String message){
        System.out.println(message);
        long choice;
        while (true){
            try{
                choice = Long.parseLong(sc.next());
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
            size = readConsoleInt("Введите размерность массива покупателей");
            if (size < 15){
                System.out.println("Колличество покупателей не может быть меньше 15!. \n"+
                        "Повторите ввод данных.");
            }
        }while (size < 15);
        Customer.customers = new Customer[size];
    }
    public static void printMenu(){
        String menu = "0. Список всех покупателей\n"+
                "1. Список покупателей в алфавмтном порядке\n"+
                "2. Список покупателей с номером кредитной карты находящимся в заданном интервале\n";
        int choice;
        do {
            choice = readConsoleInt("Сделайте выбор: \n"+menu);
            if (choice < 0 && choice > 2){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice > 2);
        switch (choice){
            case 0:{
                printAllCustomers();
            }break;
            case 1:{
                customerSort();
            }break;
            case 2:{
                cardInterval();
            }break;
        }
    }

    public static void printAllCustomers(){
        for (Customer c: Customer.customers){
            System.out.println(c);
        }
        System.out.println();
        printMenu();
    }

    public static void customerSort(){
        Arrays.sort(Customer.customers,Customer.customers[0].new CustomerSurnameComparator());
        printAllCustomers();
    }

    public static void cardInterval(){
        long from;
        long to;
        do {
            from = readConsoleLong("Введите начало интервала");
            if (from < 1000000000000000l || from > 9999999999999999l){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных\n");
            }
        }while (from < 1000000000000000l || from > 9999999999999999l);
        do {
            to = readConsoleLong("Введите конец интервала");
            if (to > 9999999999999999l || to < 1000000000000000l || to <= from){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных\n");
            }
        }while (to > 9999999999999999l || to < 1000000000000000l || to <= from );
        System.out.println("\nКарты от "+from+" до "+to+":\n");
        for (Customer c:Customer.customers){
            if (c.getCardNumber() > from && c.getCardNumber() < to){
                System.out.println(c);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < Customer.customers.length;i++){
           Customer.customers[i] = new Customer(i + 1);
        }
        printMenu();
    }
}

