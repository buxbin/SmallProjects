package studentmanagement;

public class Course {
    private String courseName;
    private int courseId;
    private Instructor instructor;

    public Course(String courseName, int courseId, Instructor instructor){
        this.courseName = courseName;
        this.courseId = courseId;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }    
}