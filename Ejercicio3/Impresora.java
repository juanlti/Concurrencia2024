/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Impresora {

    Semaphore mutexA, mutexB;

    public Impresora() {
        mutexA = new Semaphore(1);
        mutexB = new Semaphore(1);

    }

    public void impresoraDisponibleTipoA(char unC) {
        try {
            //toma el unico persmiso disponible
            mutexA.acquire();

        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void impresoraDisponibleTipoB(char unC) {
        try {
            //toma el unico persmiso disponible
            mutexB.acquire();

            //consulta el tipo de impresion
            switch (unC) {

            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Impresora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
