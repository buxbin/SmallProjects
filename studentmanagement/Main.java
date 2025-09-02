package studentmanagement;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student("Daniel", 1234);
        Student s2 = new Student("Kevin", 4321);
        Student s3 = new Student("Sinan", 2345);
        Student s4 = new Student("Eugen", 5432);
        Student s5 = new Student("Nari", 0123);
        
        Instructor i1 = new Instructor("Beige", 12);
        Instructor i2 = new Instructor("Mueller", 13);
        Instructor i3 = new Instructor("Wind", 14);
        Instructor i4 = new Instructor("Talfahrt", 15);

        Course physics = new Course("Physics", 1, i1);
        Course programming = new Course("Programming", 2, i2);
        Course biology = new Course("Biology", 3, i3);
        Course sport = new Course("Sport", 4, i3);
        Course economics = new Course("Economics", 5, i4);

        i1.addCourse(physics);
        i2.addCourse(programming);
        i3.addCourse(biology);
        i3.addCourse(sport);
        i4.addCourse(economics);

        GradeManager gm = new GradeManager();

        gm.addEnrollments(new Enrollment(s1, physics, 1.0));
        gm.addEnrollments(new Enrollment(s1, programming, 1.0));
        gm.addEnrollments(new Enrollment(s2, economics, 1.5));
        gm.addEnrollments(new Enrollment(s2, sport, 2.5));
        gm.addEnrollments(new Enrollment(s2, programming, 3.2));
        gm.addEnrollments(new Enrollment(s3, biology, 3.0));
        gm.addEnrollments(new Enrollment(s3, sport, 3.5));
        gm.addEnrollments(new Enrollment(s4, physics, 4.0));
        gm.addEnrollments(new Enrollment(s4, economics, 2.1));
        gm.addEnrollments(new Enrollment(s4, sport, 1.0));
        gm.addEnrollments(new Enrollment(s5, economics, 2.2));
        gm.addEnrollments(new Enrollment(s5, physics, 3.4));
        gm.addEnrollments(new Enrollment(s5, biology));
        gm.addEnrollments(new Enrollment(s5, programming, 1.7));

        System.out.printf("%s" + ": " + "%.2f\n", s1.getName(), gm.calculateGPA(s1));
        System.out.printf("%s" + ": " + "%.2f\n", s2.getName(), gm.calculateGPA(s2));
        System.out.printf("%s" + ": " + "%.2f\n", s3.getName(), gm.calculateGPA(s3));
        System.out.printf("%s" + ": " + "%.2f\n", s4.getName(), gm.calculateGPA(s4));
        System.out.printf("%s" + ": " + "%.2f\n", s5.getName(), gm.calculateGPA(s5));
    }
}