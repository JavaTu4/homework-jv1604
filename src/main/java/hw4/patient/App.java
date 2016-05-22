package hw4.patient;

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
            size = readConsoleInt("Введите размерность массива пациентов");
            if (size < 15) {
                System.out.println("Колличество пациентов не может быть меньше 15!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 15);
        Patient.patients = new Patient[size];
    }

    public static void printMenu(){
        String menu = "0. Список всех пациентов\n"+
                "1. Список пациентов имеющий данный диагноз\n"+
                "2. Список пациентов с номером медицинской карты находящимся в заданном интервале\n";
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
                printAllPatients();
            }break;
            case 1:{
                getByDiagnosis();
            }break;
            case 2:{
                medCardInterval();
            }break;
        }
    }

    public static void printAllPatients(){
        for (Patient p: Patient.patients){
            System.out.println(p);
        }
        System.out.println();
        printMenu();
    }

    static void getByDiagnosis(){
        for (int i = 0;i < Patient.diagnosises.length;i++){
            System.out.println(i+". " + Patient.diagnosises[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер диагноза");
            if (choice < 0 && choice >= Patient.diagnosises.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Patient.diagnosises.length);
        for (Patient p: Patient.patients){
            if (p.getDiagnosis().equals(Patient.diagnosises[choice])){
                System.out.println(p);
            }
        }
        System.out.println();
    }

    static void medCardInterval(){
        int from;
        int to;
        do {
            from = readConsoleInt("Введите начало интервала\n");
            if (from < 10000 || from >= 99999){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных\n");
            }
        }while (from < 10000 || from >= 99999);
        do {
            to = readConsoleInt("Введите конец интервала\n");
            if (to < 10000 || to > 99999 || to <= from){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных\n");
            }
        }while (to < 10000 || to > 99999 || to <= from);
        System.out.println("\nМедицинские карты от "+from+" до "+to+":\n");
        for (Patient p : Patient.patients){
            if (p.getMedCard() >= from && p.getMedCard() <= to){
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0;i < Patient.patients.length;i++){
            Patient.patients[i] = new Patient(i + 1);
        }
        printMenu();
    }
}
