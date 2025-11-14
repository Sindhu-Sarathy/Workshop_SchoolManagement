package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    @BeforeEach
    void SetUp(){
        student=new Student("Sindhuja","sarathy.sindhu@gmail.com","Östergatan");
    }

    @Test
    void testConstructors(){
        String name= student.getName();
        String email= student.getEmail();
        String address=student.getAddress();

        assertEquals("Sindhuja",name,"The name is incorrect");
        assertEquals("sarathy.sindhu@gmail.com",email,"The email is incorrect");
        assertEquals("Östergatan",address,"The address is incorrect");

    }

    @Test
    void testToString() {

    }
}