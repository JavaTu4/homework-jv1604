package homework4;

import java.util.ArrayList;

/**
 * Created by root on 26.04.16.
 */
public class App {
    public static void main(String[] args) {
        for (int i = 0; i <=50; i++) {
            Student student = new Student();
        }
//        Student student = new Student(Student.autoId(Student.students.size()), Student.autoSurname(), Student.autoName(),Student.autoMiddleName(),Student.autoDateOfBirth(),Student.autoAddress(),Student.autoPhoneNumber(),Student.autoFaculty(),Student.autoCourse());

        System.out.println(Student.students);

//        Student.listOfFaculty(Student.faculties[2]);
//
//        Student.listsOfFacultiesAndCourses();
//
//        Student.listOfgroup();

        Student.afterYear(1993);

    }
}
