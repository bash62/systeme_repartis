package main;
import java.util.zip.CRC32;

import classes.*;

public class Main {
    public static void main(String[] args) {
        try { 
            //System.in.read(); 
        }
        catch( Exception e ) { }
        Buffer b = new Buffer(10);
        Producteur p = new Producteur(b);
        Consommateur c1 = new Consommateur(b, 1);

    }
}