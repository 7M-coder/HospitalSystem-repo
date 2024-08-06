
package Hospital;

public class AdministrationStaff extends Employees {
    
    // constructor
    public AdministrationStaff(int id, String fName, String lName, String phone, String email, double salary, String position) {
        
        // Employees constructor
        super(id, fName, lName, phone, email, salary);        
        this.position = position;
    }
    
    private String position;
    
    
    // setters
    public void setPosition(String position) {
        
        this.position = position;
    }
    
    // getters
    public String getPosition() {
        
        return position;
    }

    // the toString method - string representation of the object created from this class
    
    @Override
    public String toString() {
        
        return "Administration Informations:\n" + "Id: " + getId() + "\nFirst Name:" + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getPhoneNumber() + "\nEmail: " + getEmail() + "\nSalary: " + getSalary() + "\nPosition: " + getPosition();
    }
}
