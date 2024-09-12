/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Correr {

    private boolean libre;
    private String ultimo;

    public Correr() {
        this.libre = true;
        this.ultimo = "";
    }

    public synchronized boolean getEntrar(String ingresante) {

        if (ingresante.equalsIgnoreCase(ultimo)) {
            return false;
        } else {
            if (this.libre) {
                this.ultimo = ingresante;
                this.libre = false;
                return true;
            } else {
                return false;
            }
        }

    }

    public synchronized void correr(String unNombre) {

        try {

            System.out.println(unNombre + " Empezando a correr");
            Thread.sleep(util.descansa(50, 350));
            System.out.println(unNombre + " Terminando de  correr");
            this.libre = true;
            this.ultimo = "";

        } catch (InterruptedException ex) {
            Logger.getLogger(Correr.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
