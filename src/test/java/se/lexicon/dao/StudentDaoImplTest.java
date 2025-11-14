package se.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.lexicon.model.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoImplTest {
    Student  student=new Student("Sindhuja","sarathy.sindhu@gmail.com","Östergatan");
    StudentDao studentDao;

    @BeforeEach
    void setUp() {
       studentDao=new StudentDaoImpl();
    }

    @Test
    void save_newStudent_returnStudent() {
        Student studentAdded=studentDao.save(student);
        assertEquals(student,studentAdded);
    }
    @Test
    void save_existing_throwsRuntimeException() {
        studentDao.save(student);
        Executable action = () -> studentDao.save(student);

        assertThrows(RuntimeException.class,action,"The student is already exists!");
    }

    @Test
    void save_existing_throwsIllegalArgumentException() {
        Executable action = () -> studentDao.save(null);

        assertThrows(RuntimeException.class,action,"The student is null or empty!");
    }

    @Test
    void findByEmail_emailExists_returnfirstFound() {
        studentDao.save(student);
        Student foundStudent=studentDao.findByEmail(student.getEmail());
        assertEquals(student,foundStudent);
    }

    @Test
    void findByEmail_emailDontExists_returnNull() {
        studentDao.save(student);
        Student foundStudent=studentDao.findByEmail("nonexistent");
        assertNull(foundStudent);
    }

    @Test
    void findByName_nameExists_returnAllFound() {
        studentDao.save(student);
        List<Student> studentsFound=studentDao.findByName(student.getName());
        assertEquals(1,studentsFound.size());
        assertEquals(student,studentsFound.get(0),"Found the student by name");
    }

    @Test
    void findByName_nameDontExists_returnNull() {
        studentDao.save(student);
        List<Student> studentsFound=studentDao.findByName("nonexistent");
        assertNull(studentsFound,"The Students not found");
    }

    @Test
    void findById_exists_returnfirstFound() {
        studentDao.save(student);
        Student foundById=studentDao.findById(student.getId());
        assertEquals(student,foundById);
    }

    @Test
    void findById_dontexists_returnNull() {
        Student foundById=studentDao.findById(student.getId());
        assertNull(foundById);
    }

    @Test
    void findAll_afteradded_returnOne() {
        studentDao.save(student);
        List<Student> students=studentDao.findAll();
        assertEquals(1,students.size());
        assertEquals(student,students.get(0));
    }

    @Test
    void delete_studentExist_returnTrue() {
        studentDao.save(student);
        boolean result=studentDao.delete(student);
        assertTrue(result);
    }

    @Test
    void delete_studentDontExist_returnFalse() {
        boolean result=studentDao.delete(student);
        assertFalse(result);
    }

    @Test
    void delete_ThrowsIllegalArgumentException() {
        Executable action = () -> studentDao.delete(null);
        assertThrows(RuntimeException.class,action,"The student is null or empty!");
    }
}