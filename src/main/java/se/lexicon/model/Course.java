package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Course {
    private static int sequencer=0;
    private final int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new LinkedList<Student>();

    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.id = sequencer++;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void register(Student student)
    {
        if(students.contains(student)){
            throw new RuntimeException("Student already registered for this course!");
        }
        else if(student == null){
            throw new IllegalArgumentException("The Student is null or empty");
        }
       students.add(student);
    }

    public void unregister(Student student)
    {
        if(students.contains(student)) {
            students.remove(student);
        }
        else if(student==null){
            throw new IllegalArgumentException("The Student is null or empty");
        }

//        throw new RuntimeException("The Student was not registered!");
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
