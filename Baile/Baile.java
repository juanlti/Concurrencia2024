/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baile;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Baile {

    Semaphore caballero, dama, bailar, ingresarSala, caballeroListo, damaLista;
    String parejaFormada;

    public Baile() {
        parejaFormada = "";
        caballero = new Semaphore(1);
        dama = new Semaphore(1);
        bailar = new Semaphore(0);

        caballeroListo = new Semaphore(0);
        damaLista = new Semaphore(0);

    }

    public void filaVaron(int nombre) {
        try {
            caballero.acquire();
            System.out.println("Orden de caballero "+nombre);
            damaLista.acquire();
            parejaFormada = parejaFormada + " caballero " + nombre + " --- ";
            this.caballeroListo.release();

            bailar.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Baile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void filaDama(int nombre) {
        try {
            dama.acquire();
            damaLista.release();
              System.out.println("Orden de dama "+nombre);
            this.caballeroListo.acquire();
            parejaFormada = parejaFormada + " dama " + nombre + " --- ";
            bailar.release();

        } catch (InterruptedException ex) {
            Logger.getLogger(Baile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bailar() {
        try {
            bailar.acquire(2);
            System.out.println("Bailando " + parejaFormada);

            parejaFormada = "";
            Thread.sleep(500);
            dama.release();
            caballero.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Baile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
