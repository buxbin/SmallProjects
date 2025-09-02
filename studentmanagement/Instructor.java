package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private List<Course> coursesGiven;
    private String name;
    private int employeeNumber;

    
    public Instructor(String name, int employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        coursesGiven = new ArrayList<>();
    }

    public void addCourse(Course c){
        coursesGiven.add(c);
    }

    public List<Course> getCoursesGiven() {
        return coursesGiven;
    }
    public void setCoursesGiven(List<Course> coursesGiven) {
        this.coursesGiven = coursesGiven;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    

}