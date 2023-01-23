package classes;
import classes.Semaphore;

public class Buffer {

    int size = 10;
    double[] buffer = new double[size];
    Semaphore semProducteur = new Semaphore(size);
    Semaphore semConso = new Semaphore(0);

    public Buffer(int n) {
        size = n ;
    }
    public void depot(double value) {

        //On acquire le semaphore du producteur
        // Le semaphore fait -- car il acquire 
        semProducteur.acquire();
        for(int i=0; i<size;i++){
            if(buffer[i] == 0){
                buffer[i] = value;
                break;
            }
        }

        // On realease le semaphore du consomateur pour lui permettre de récupérer 
        semConso.realease();
        
        
    }
    public double retrait() {
        double value = 0;
        semConso.acquire();
        
        for(int i = 0;i<size ;i++){
            if(buffer[i] != 0){
                value = buffer[i];
                System.out.println("position : "+ i+ " buffer: "+ buffer[i]);
                buffer[i] = 0;
                break;
            }
        }
        semProducteur.realease();
        return value;
    }
}