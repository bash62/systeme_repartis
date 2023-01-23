/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author mcilj
 */
public class TP1buffer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*************
        * EXERCICE 1 *
        *************/
         
        /*
        Buffer buff = new Buffer(10); //nouveau buffer taille = 10
        
        Producteur producteur = new Producteur(buff); //producteur qui utilise ce buffer
        Consommateur consommateur1 = new Consommateur(buff, 1); //consommateur qui utilise le buffer
        //Consommateur consommateur2 = new Consommateur(buff, 2); //autre consommateur
        
        
        try {
            System.in.read();
        } catch( Exception e ) { }
        System.exit(0);

        */
        
        
        /*************
         * EXERCICE 2 *
         *************/
        
        //on teste avec 5 philosophes
        int nbPhilosophes = 5;
        Semaphore[] fourchettes = new Semaphore[nbPhilosophes];
        
        for (int i = 0; i < nbPhilosophes; i++) {
            fourchettes[i] = new Semaphore(1);
        }
        
        for (int i = 0; i < nbPhilosophes; i++) {
            Philosophe p = new Philosophe(i, fourchettes);
            new Thread(p).start();
        }
        
    }    
}
