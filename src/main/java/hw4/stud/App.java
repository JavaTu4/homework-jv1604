package hw4.stud;

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
            size = readConsoleInt("Введите размерность массива студентов");
            if (size < 15){
                System.out.println("Колличество студентов не может быть меньше 15!. \n"+
                "Повторите ввод данных.");
            }
        }while (size < 15);
            Student.students = new Student[size];
    }

    public static void printMenu(){
        String menu = "0. Список всех студентов\n"+
                "1. Список заданного факультета\n"+
                "2. Списки всех Факультетов\n"+
                "3. Списки всех курсов\n"+
                "4. Список студентов родившихся после заданного года\n"+
                "5. Список учебной группы\n";
        int choice;
        do {
            choice = readConsoleInt("Сделайте выбор: \n"+menu);
            if (choice < 0 && choice > 5){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice > 5);

        switch (choice) {
            case 0: {
                printAllStudents();
            }break;
            case 1: {
                getByFaculty();
            }break;
            case 2: {
                listOfFaculties();
            }break;
            case 3: {
                listOfCourses();
            }break;
            case 4: {
                listOfOld(readConsoleInt("Введите год"));
            }break;
            case 5: {
                listOfGroup();
            }
        }
    }

    public static void printAllStudents(){
        for (Student st: Student.students){
            System.out.println(st);
        }
        System.out.println();
        printMenu();
    }

    static void getByFaculty(){
        for (int i = 0;i < Student.faculties.length;i++){
            System.out.println(i+". " + Student.faculties[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер факультета");
            if (choice < 0 && choice >= Student.faculties.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Student.faculties.length);
        for (Student st : Student.students){
            if (st.getFaculty().equals(Student.faculties[choice])){
                System.out.println(st);
            }
        }
        System.out.println();
    }

    static void listOfFaculties(){
        for (int i = 0;i < Student.faculties.length;i++) {
            System.out.println(Student.faculties[i]+"\n");
            for (Student st : Student.students) {
                if (st.getFaculty().equals(Student.faculties[i])) {
                    System.out.println(st);
                }
            }
            System.out.println();
        }
    }

    static void listOfCourses(){
        for (int j = 1;j <= 5;j++){
            System.out.println("Студенты "+j+" курса\n");
            for (Student st : Student.students){
                if (st.getCourse() == j){
                    System.out.println(st);
                }
            }
            System.out.println();
        }
    }

    static void listOfOld(int year){
        System.out.println("Список студентов после "+year+" года рождения\n");
        int yearOfBirth;
        for (Student st : Student.students){
            yearOfBirth = Integer.parseInt(st.getDateOfBirth().substring(0,4));
            if (yearOfBirth > year){
                System.out.println(st);
            }
        }
    }

    static void listOfGroup(){
        for (int i = 0;i < Student.faculties.length;i++){
            System.out.println(i+". " + Student.faculties[i]);
        }
        int choice;
        do {
            choice = readConsoleInt("Введите номер факультета");
            if (choice < 0 && choice >= Student.faculties.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choice < 0 && choice >= Student.faculties.length);

        int choiceCourse;
        do {
            choiceCourse = readConsoleInt("Введите курс");
            if (choiceCourse < 1 && choiceCourse > 5){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choiceCourse < 1 && choiceCourse > 5);

        for (int i = 0;i < Student.groups.length;i++){
            System.out.println(i+". " +Student.faculties[choice].charAt(0)+"-"+Student.groups[i]);
        }
        int choiceGroup;
        do {
            choiceGroup = readConsoleInt("Введите номер группы");
            if (choiceGroup < 0 && choiceGroup >= Student.groups.length){
                System.out.println("неверное значение. \n"+
                        "повторите ввод данных");
            }
        }while (choiceGroup < 0 && choiceGroup >= Student.groups.length);

        System.out.println("Группа "+Student.faculties[choice].charAt(0)+"-"+Student.groups[choiceGroup]+
                " "+choiceCourse+" курс "+Student.faculties[choice]+" факультет\n");

        for (Student st : Student.students){
            if (st.getFaculty().equals(Student.faculties[choice]) &&
                    st.getCourse() == choiceCourse &&
                    Integer.parseInt(st.getGroup().substring(2,4)) == Student.groups[choiceGroup]){
                System.out.println(st);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < Student.students.length;i++){
            Student.students[i] = new Student(i + 1);
        }
        printMenu();
    }
}

