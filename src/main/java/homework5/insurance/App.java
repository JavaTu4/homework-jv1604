package homework5.insurance;

import homework5.insurance.liabilities.*;

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

    static Liability[] derivative;

    static void printMenu(){
        String menu = "\n0. Вывести список всех обязательств в деривативе\n"+
                "1. Сортировка обязательств в деривативе на основе уменьшения степени риска\n"+
                "2. Поиск обязательств в заданном диапазоне ежемесячной платы\n";
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
                printDerivative();
            }break;
            case 1:{
                sortByRiskLevel();
            }break;
            case 2:{
                getByMonthlyInstallment();
            }break;
        }
    }

    static String getPrice (){
        int price = 0;
        for (Liability l:derivative){
            price += l.getRepayment();
        }
        return "Общая стоимость дериватива = " + price + " $";
    }

    static void printDerivative (){
        System.out.println("Дериватив из " + derivative.length + " обязательств\n");
        for (Liability l:derivative){
            System.out.println(l);
        }
        System.out.println();
        System.out.println(getPrice());
        printMenu();
    }

    static void sortByRiskLevel (){
        Arrays.sort(derivative,derivative[0].new LiabililyRiskLevelComparator());
        printDerivative();
    }

    static void getByMonthlyInstallment (){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона ежемесячной платы(от 100)\n");
            if (from < 100 || from >= 5000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 100 || from >= 5000);
        do {
            to = readConsoleInt("\nВведите конец диапазона ежемесячной платы(до 5001)\n");
            if (to <= from || to > 5000){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >5000);
        System.out.println("\nОбязательства с ежемесячной платой от "+from+" до "+to+" км/час\n");
        for (Liability l:derivative){
            if (l.getMonthlyInstallment() > from && l.getMonthlyInstallment() < to){
                System.out.println(l);
            }
        }
        System.out.println();
    }

    static int sizeOfDerivative(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество обязательств в деривативе: (от 25 до 100)\n");
            if (size < 25 || size > 100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 25 || size > 100);
        return size;
    }

    static Liability switchAddLiability(int choice){
        Liability liability = null;
        switch (choice){
            case 1:{
                liability = new Business();
            }break;
            case 2:{
                liability = new Car();
            }break;
            case 3:{
                liability = new Health();
            }break;
            case 4:{
                liability = new Home();
            }break;
        }
        return liability;
    }

    static void randomDerivative(){
        sc = new Scanner(System.in);
        derivative = new Liability[sizeOfDerivative()];
        for (int i = 0;i < derivative.length;i++){
            derivative[i] = switchAddLiability(random(1,4));
        }
        printMenu();
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static void main(String[] args) {
        randomDerivative();
    }
}
