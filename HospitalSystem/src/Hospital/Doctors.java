package Hospital;

import java.util.Vector;
public class Doctors extends Employees {
       
    private String rank;
    private String specialty;
    
    private Vector<Patients> patients ;
    
    // constructor
    public Doctors(int id, String fName, String lName, String phone, String email, double salary  ,String rank, String specialty) {
        
        // Employees constructor
        super(id, fName, lName, phone, email, salary);
        
        this.rank = rank;
        
        this.specialty = specialty;    
        
        patients = new Vector<>();
        
    }
   
    
    // setters
    
    public void setRank(String rank) {
        
        this.rank = rank;
    }
    
    public void setSpecialty(String specialty) {
        
        this.specialty = specialty;
    }
    
    // getters
    
    public String getRank() {
        
        return rank;
    }
    
    public String getSpecialty() {
        
        return specialty;
    }
    
    public Vector<Patients> getPatients() {
        
        return patients;
    }
   
    // the toString method - string representation of the object created from this class
    @Override
    public String toString() {
        
        String patient = "";
        for(Patients pat:patients) {
            
            patient += pat.getFirstName() + " " + pat.getLastName() + "|";
        }
        
        if(patient.equals("")) {
            
            patient = "None";
        }
        return "Doctors Informations:\n" + "id: " + getId() + "\nFirst Name:" + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getPhoneNumber() + "\nEmail: " + getEmail() + "\nSalary: " + getSalary() + "\nRank: " + getRank() + "\nspecialty: " + getSpecialty() + "\nPateints treated by this doctor: " + patient; 
    }
}
