/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author iliesJ
 */
public class Buffer {
    int size = 10;
    double[] buffer = new double[size];
    
    int read = 0;
    int write = 0;
    
    Semaphore sem1 = new Semaphore(1); // synchroniser accès au buffer.
    Semaphore semvide = new Semaphore(size); // synchroniser les retraits (peut etre lu autant de fois qu'il y a de size
    Semaphore semsync = new Semaphore(0); //synchroniser les dépôts

    public Buffer(int n) {
        size = n;
    }

    public void depot(double value) {
        semvide.P(); //attend que le buffer soit vide.
        sem1.P(); //attend l'accès au buffer pour le verrouiller.
        buffer[write] = value; //Met la valeur du depot dans le dernier buffer.
        write = (write++ % size); //Write sequence et Read sequence se suivent toujours dans la size du buffer.
        sem1.V(); //libère l'accès au buffer
        semsync.V(); //Dit que le buffer est rempli.
    }

    public double retrait() {
        double value = 0;
        semsync.P(); //Pareil que depot mais dans l'autre sens: attend que le buffer soit rempli.
        sem1.P(); //Attend l'accès au buffer pour le verrouiller.
        value = buffer[read]; //on prend le buffer au read.
        read = (read++ % size); //Read suit write dans le buffer. (entre 1 et 10 si size==10).
        sem1.V(); //déverrouille le buffer
        semvide.V(); //Dit que le buffer est lu (il y a de la place à nouveau).
        return value;
    }
}