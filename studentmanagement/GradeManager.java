package studentmanagement;

import java.util.ArrayList;
import java.util.List;

public class GradeManager {
    private List<Enrollment> enrollments;

    public GradeManager(){
        enrollments = new ArrayList<>();
    }

    public void addEnrollments(Enrollment en){
        enrollments.add(en);
    }

    public Double getGrade(Student s, Course c){
        for(Enrollment en : enrollments){
            if(en.getStudent().equals(s) && en.getCourse().equals(c)){
                return en.getGrade();
            }
        }
        return null;
    }

    public List<Course> getCoursesForStudent(Student s){
        List<Course> coursesTaken = new ArrayList<>();

        for(Enrollment en : enrollments){
            if(en.getStudent().equals(s)){
                coursesTaken.add(en.getCourse());
            }
        }
        return coursesTaken;
    }

    public List<Student> getStudentsForCourses(Course c){
        List<Student> attendanceList = new ArrayList<>();

        for(Enrollment en : enrollments){
            if(en.getCourse().equals(c)){
                attendanceList.add(en.getStudent());
            }
        }

        return attendanceList;
    }

    public Double calculateGPA(Student s){
        double sum = 0;
        int count = 0;

        for(Enrollment en : enrollments){
            if(en.getStudent().equals(s) && en.getGrade() != null){
                sum += en.getGrade();
                count++;
            }
        }

        return (count > 0) ? (sum / count) : 0.0;
    }
}