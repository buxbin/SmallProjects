package studentmanagement;

public class Student{
    private String name;
    private int registrationNumber;

    
    public Student(String name, int registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    
}