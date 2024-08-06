
package Hospital;

public abstract class Identifier {
    
    private int id;
    
    Identifier(int id) {
        
        this.id = id;
    }
    
    // setter 
    public void setId(int id) {
        
        id = id;
    }
    
    // getter
    public int getId() {
        
        return id;
    }
}
