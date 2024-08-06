package Hospital;

import java.util.Vector;
public class Patients extends Person {
    
    enum Types{A, B, C};
    
    private Vector<Services> services; 
    private Doctors doctor ;
    
    
    Types type;
    double bill = 0;
    
    // constructor
    public Patients(int id, String fName, String lName, String phone, String email, String type, double bill) {
        
        // Person constructor
        super(id, fName, lName, phone, email);
        services = new Vector<Services>();
        
        switch(type) {
            
            case "A":
                
                this.type = Types.A;
                
                this.bill = bill * 0.6;
            break;
            
            case "B":
                this.type = Types.B;
                this.bill = bill;
            break;
            
            case "C":
                this.type = Types.C;
                this.bill = bill;
            break;
        }
        
    }
    
   
   // setters
    
   public void setServices(Services service) {
       
       services.add(service);
   }
   
   public void setDoctor(Doctors doctor) {
       
       this.doctor = doctor;
   }
   
   // getters
   public Types getType() {
       
       return type;
   }
   public double getBill() {
       
       return bill;
   }
   public Vector getServices() {
       
       return services;
   }
   
   public Doctors getDoctor() {
       
       return this.doctor;
   }

    // the toString method - string representation of the object created from this class
   
   @Override
   public String toString() {
        
        String service = "";
        String doctor = this.doctor.getFirstName() + " " + this.doctor.getLastName();
        for(Services serv:services) {
            
           service += serv.getName() + "|";
        }
        
       
        return "Patient informations: \n" + "First Name: " + getFirstName() + "\nLast Name: " + getLastName() + "\nPhone Number: " + getLastName() + "\nEmail: " + getEmail() + "\nType: " + getType() + "\nPatient's Services: " + service + "\nThe Patient treated by Dr." + doctor;
   }
}
