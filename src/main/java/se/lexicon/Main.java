package se.lexicon;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Student stu1=new Student("Sindhu","test@gmail.com","test 123");
        Student stu2=new Student("Test","test1@gmail.com","test 456");

        Course course=new Course("JAVA", LocalDate.now(),6);

        course.register(stu1);
        course.register(stu2);

        System.out.println(course);

    }
}