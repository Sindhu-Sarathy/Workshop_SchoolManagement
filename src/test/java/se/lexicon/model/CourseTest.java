package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;
    String courseName="JAVA";
    LocalDate startDate=LocalDate.now();
    int weekDuration=60;
    Student student=new Student("Sindhu","test@gmail.com","test 123");

    @BeforeEach
    void SetUp(){
        course= new Course(courseName,startDate,weekDuration);
    }

    @Test
    void register_nonexisting_student_added() {
        //Arrange
        course.register(student);

        //Act
        Student studentAdded=course.getStudents().get(course.getStudents().size()-1);

        //Assert
        assertEquals(student,studentAdded,"The student not registered for the course!");

    }

    @Test
    void register_existing_throwsRuntimeException() {
        course.register(student);
        Executable action = () -> course.register(student);

        assertThrows(RuntimeException.class,action,"The student was registered!");
    }

    @Test
    void register_existing_throwsIllegalArgumentException() {
        Executable action = () -> course.register(null);

        assertThrows(RuntimeException.class,action,"The student is null or empty!");
    }

    @Test
    void unregister_existing_student_removed() {
        course.register(student);
        course.unregister(student);
        int courseNumElements=course.getStudents().size();
        assertEquals(0,courseNumElements,"The student was not unregistered!");
    }

    @Test
    void unregister_nonexisting_throwsRuntimeException() {

        Executable action = () -> course.unregister(student);

        assertThrows(RuntimeException.class,action,"The student was not registered!");
    }

    @Test
    void unregister_existing_throwsIllegalArgumentException() {
        Executable action = () -> course.register(null);

        assertThrows(RuntimeException.class,action,"The student is null or empty!");
    }
}