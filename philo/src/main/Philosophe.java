/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package philo.src.main;

/**
 *
 * @author mcilj
 */
public class Philosophe implements Runnable{
    int idPhilo;
    Semaphore[] fourchettes;
    
    public Philosophe(int idPhilo, Semaphore[] fourchettes){
        this.idPhilo = idPhilo;
        this.fourchettes = fourchettes;
    }
    
    public void run(){
        while (true){
            //1: penser
            
            //pense pendant un temps aléatoire
            try{
                Thread.sleep((int)(Math.random()* 2000));
            } catch (InterruptedException e){ }
            
            //2: faim
            
            System.out.println(idPhilo + " a faim. Il veut se nourrir pour mieux réfléchir.");
            
            //3: manger
            
            int fourchetteGauche = idPhilo;
            int fourchetteDroite = (idPhilo + 1) % fourchettes.length;
            
             //Il attend son tour pour privatiser les fourchettes
            fourchettes[fourchetteGauche].P();
            fourchettes[fourchetteDroite].P();
            
            System.out.println(idPhilo + " mange avec les fourchettes " + fourchetteGauche + " et " + fourchetteDroite + ".");
            
            //mange pendant un temps aléatoire
            try {
                Thread.sleep((int)(Math.random() * 2000));
            } catch (InterruptedException e) { }
            
            //libère les fourchettes.
            fourchettes[fourchetteGauche].V();
            fourchettes[fourchetteDroite].V();
            
        } 
    }
}
