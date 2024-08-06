
package Hospital;

public abstract class Person extends Identifier {
    
    // contstructor
    Person(int id, String fName, String lName, String phone, String email) {
        
        super(id); // Identifier constructor
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
    }
    
    private String fName;
    private String lName;
    private String phone;
    private String email;
    
    
    // setters
    public void setFirstName(String fName) {
        
        this.fName = fName;
    }
    public void setLastName(String lName) {
        
        this.lName = lName;
    }
    public void setPhoneNumber(String phone) {
        
        this.phone = phone;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }
    
    // getters
    public String getFirstName() {
        
        return fName;
    }
    public String getLastName() {
        
        return lName;
    }
    public String getPhoneNumber() {
        
        return phone;
    }
    public String getEmail() {
        
        return email;
    }

}
