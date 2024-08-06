package Hospital;

public abstract class Employees extends Person {
    
    private double salary;
    
    // constructor
    public Employees(int id , String fName, String lName, String phone, String email, double salary) {
        
        // Person constructor
        super(id, fName, lName, phone, email);
        this.salary = salary;
    }
    


       
    // setters
    public void setSalary(double salary) {
        
        this.salary = salary;
    }
   
    
    // getters   
    public double getSalary() {
        
        return salary;
    }
    
}
