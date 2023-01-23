/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

public class Semaphore {

    private int value;

    public Semaphore (int initial){
        value = initial;
    }

    public synchronized void V() {
        ++value;
        notify();
    } // V

    public synchronized void P() {
        try {
            while (value == 0) wait();
        }

        catch (InterruptedException e) {};

        --value;
    } // P
}