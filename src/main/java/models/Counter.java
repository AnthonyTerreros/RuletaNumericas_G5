package models;

/**
 *
 * @author dante
 */
public class Counter {
    public static int countClickbtnRIZQ = 0;
    
    public static int countClickbtnRDER = 0;
    
    public static int countClickbtnELI = 0;
    
    public static Counter counter;
    
    private Counter(){
        
    }
    
    public static Counter getInstance(){
        if(counter == null){
            counter = new Counter();
        }
        return counter;
    }
}
