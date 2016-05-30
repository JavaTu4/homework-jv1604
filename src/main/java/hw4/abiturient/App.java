package hw4.abiturient;

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
            size = readConsoleInt("Введите размерность массива абитуриентов");
            if (size < 15) {
                System.out.println("Колличество абитуриентов не может быть меньше 15!. \n" +
                        "Повторите ввод данных.");
            }
        } while (size < 15);
        Abiturient.abiturients = new Abiturient[size];
    }

    public static void printMenu(){
        String menu = "0. Список всех абитуриентов\n"+
                "1. Список абитуриентов имеющих тройки\n"+
                "2. Список абитуриентов у которых сумма баллов выше заданной\n"+
                "3. Список из заданного числа абитуриентов имеющих самую высокую сумму баллов\n";
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
                printAllAbiturients();
            }break;
            case 1:{
                listOfDeficient();
            }break;
            case 2:{
                listOfSum();
            }break;
            case 3:{
                listOfHighEq();
            }break;
        }
    }


    public static void printAllAbiturients(){
        for (Abiturient a:Abiturient.abiturients){
            System.out.println(a);
        }
        System.out.println();
        printMenu();
    }

    public static void listOfDeficient(){
        for (Abiturient a:Abiturient.abiturients){
            for (int i = 0;i < a.getEvaluations().length;i++){
                if (a.getEvaluations()[i] == 3){
                    System.out.println(a);
                    break;
                }
            }
        }
    }

    public static void listOfSum(){
        int choice;
        do {
            choice = readConsoleInt("Введите сумму баллов");
            if (choice < 9 && choice >= 15){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 9 && choice >= 15);
        for (Abiturient a:Abiturient.abiturients){
            if (a.getSumOfEv() > choice){
                System.out.println(a);
            }
        }
    }

    public static void listOfHighEq(){
        int choice;
        Abiturient[]abiturients;
        do {
            choice = readConsoleInt("Введите число абитурентов");
            if (choice < 0 && choice >= Abiturient.abiturients.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 9 && choice >= Abiturient.abiturients.length);
        abiturients = new Abiturient[choice];
        Abiturient[] abiturientsOriginalCopy = new Abiturient[Abiturient.abiturients.length - abiturients.length];
        for (int barier = Abiturient.abiturients.length - 1;barier >= 0; barier--){
            for (int index = 0;index < barier;index++){
                if (Abiturient.abiturients[index].getSumOfEv() > Abiturient.abiturients[index + 1].getSumOfEv()){
                    Abiturient tmp = Abiturient.abiturients[index];
                    Abiturient.abiturients[index] = Abiturient.abiturients[index + 1];
                    Abiturient.abiturients[index + 1] = tmp;
                }
            }
        }
        for (int i = 0;i < abiturients.length;i++){
            abiturients[i] = Abiturient.abiturients[(Abiturient.abiturients.length - 1) - i];
            System.out.println(abiturients[i]);
        }
        System.arraycopy(Abiturient.abiturients,0,abiturientsOriginalCopy,0,(Abiturient.abiturients.length - abiturients.length) - 1);
        System.out.println();
        System.out.println("Абитуриенты имеющие полупроходной бал "+abiturients[abiturients.length - 1].getSumOfEv()+"\n");
        for(Abiturient a:Abiturient.abiturients){
            if(a.getSumOfEv() == abiturients[abiturients.length - 1].getSumOfEv()){
                System.out.println(a);
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0;i < Abiturient.abiturients.length;i++){
            Abiturient.abiturients[i] = new Abiturient(i + 1);
        }
        printMenu();
    }
}
