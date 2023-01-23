package classes;
public class Semaphore {
    private int value;
    
    public Semaphore (int initial){
        value = initial;
    }
    public synchronized void realease() {
        ++value;
        notify();
    } // V
    public synchronized void acquire() {

        try {
            while (value == 0) wait();
        }
        catch (InterruptedException e) {};
            
        --value;   
    } // P
}