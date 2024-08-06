
package Hospital;

public class Services extends Identifier{
    

    private String name;
    private double price;
    
    // constructor
    public Services(int id, String name, double price) {
        
        super(id); // Identifier constructor
        this.name = name;
        this.price = price;
    }
    
    
    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    // the toString method - string representation of the object created from this class
        
    @Override
    public String toString() {
        
        return  "Service Id: " + getId() + "\nService Name: " + getName() + "\nPrice: " + getPrice();
    }
    
}
