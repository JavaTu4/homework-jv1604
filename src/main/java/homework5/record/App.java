package homework5.record;

import homework5.record.tracks.Track;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by root.
 */
public class App {
    static Scanner sc;
    static Track[] disk;
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
        String menu = "\n0. Вывести информацию о сборке\n"+
                "1. Сортировка композиций диска на основе принадлежности к жанру\n"+
                "2. Поиск композиции на диске соответствующему заданному диапазону длинны треков\n";
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
                printDisk();
            }break;
            case 1:{
                sortByGenre();
            }break;
            case 2:{
                getByDuration();
            }break;
        }
    }

    static void printDisk(){
        System.out.println("\nСборка из "+disk.length+" композиций\n");
        for (Track t:disk){
            System.out.println(t);
        }
        System.out.println("\nДлительность сбоки = "+getDuration()+" минут\n");
        printMenu();
    }

    static void sortByGenre(){
        Arrays.sort(disk,disk[0].new TrackGenreComparator());
        printDisk();
    }

    static void getByDuration(){
        int from;
        int to;
        do {
            from = readConsoleInt("\nВведите начало диапазона длинны трека в секундах (от 120)\n");
            if (from < 120 || from > 421){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (from < 120 || from > 419);
        do {
            to = readConsoleInt("\nВведите конец диапазона длинны трека в секундах (до 420)\n");
            if (to <= from || to >420){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (to <= from || to >420);
        System.out.println("\nКомпозиции длительностью от "+from+" до "+to+" секунд\n");
        for (Track t:disk){
            if (t.getDuration() > from && t.getDuration() < to){
                System.out.println(t);
            }
        }
        System.out.println();
    }

    static int getDuration(){
        int duration = 0;
        for (Track t:disk){
            duration += t.getDuration();
        }
        return duration / 60;
    }

    static int sizeOfDisk(){
        int size;
        do {
            size = readConsoleInt("\nВведите количество треков на диске: (от 15 до 100)\n");
            if (size < 15 || size > 100){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (size < 15 || size > 100);
        return size;
    }

    static void randomDisk(){
        sc = new Scanner(System.in);
        disk = new Track[sizeOfDisk()];
        for (int i = 0;i < disk.length;i++){
            disk[i] = new Track();
        }
        printMenu();
    }

    public static void main(String[] args) {
        randomDisk();
    }
}
