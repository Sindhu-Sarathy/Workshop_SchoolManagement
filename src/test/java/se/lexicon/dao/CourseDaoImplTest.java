package se.lexicon.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoImplTest {
    Course course=new Course("JAVA", LocalDate.now(),60);
    CourseDao courseDao;


    @BeforeEach
    void setUp() {
        courseDao=new CourseDaoImpl();
    }

    @Test
    void save_newCourse_returnCourse() {
        Course courseAdded=courseDao.save(course);
        assertEquals(course,courseAdded);
    }

    @Test
    void save_existingCourses_throwsRuntimeException() {
        courseDao.save(course);
        Executable action = () -> courseDao.save(course);

        assertThrows(RuntimeException.class,action,"The Course is already exists!");
    }

    @Test
    void save_existing_throwsIllegalArgumentException() {
        Executable action = () -> courseDao.save(null);

        assertThrows(RuntimeException.class,action,"The Course is null or empty!");
    }

    @Test
    void findById_exists_returnFirstFound() {
        courseDao.save(course);
        Course foundId=courseDao.findById(course.getId());
        assertEquals(course,foundId);
    }

    @Test
    void findById_DontExists_returnNull() {
        Course foundById=courseDao.findById(course.getId());
        assertNull(foundById);
    }


    @Test
    void findByName_nameExists_returnAllFound() {
        courseDao.save(course);
        List<Course> coursesFound=courseDao.findByName(course.getCourseName());
        assertEquals(1,coursesFound.size());
        assertEquals(course,coursesFound.get(0),"Found the course by name");
    }

    @Test
    void findByName_nameDontExists_returnNull() {
        courseDao.save(course);
        List<Course> coursesFound=courseDao.findByName("Nonexistent");
        assertNull(coursesFound,"The Course is not found");
    }

    @Test
    void findByDate_DateExists_returnAllFound() {
        courseDao.save(course);
        List<Course> coursesFound=courseDao.findByDate(course.getStartDate());
        assertEquals(1,coursesFound.size());
        assertEquals(course,coursesFound.get(0),"Found the course by date");
    }

    @Test
    void findByDate_DontExists_returnNull() {
        courseDao.save(course);
        List<Course> coursesFound=courseDao.findByDate(null);
        assertNull(coursesFound,"The Course is not found");
    }

    @Test
    void findAll() {
        courseDao.save(course);
        List<Course> courses=courseDao.findAll();
        assertEquals(1,courses.size());
        assertEquals(course,courses.get(0),"The course details");
    }

    @Test
    void delete_CourseExist_returnTrue() {
        courseDao.save(course);
        boolean result=courseDao.delete(course);
        assertTrue(result,"The Course is deleted!");
    }

    @Test
    void delete_studentDontExist_returnFalse() {
        boolean result=courseDao.delete(course);
        assertFalse(result,"The Course is not deleted");
    }

    @Test
    void delete_ThrowsIllegalArgumentException() {
        Executable action = () -> courseDao.delete(null);
        assertThrows(RuntimeException.class,action,"The Course is null or empty!");
    }
}