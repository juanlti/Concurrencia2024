/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Comer {

    private boolean libre;
    private String ultimo;

    public Comer() {
        this.libre = true;
        this.ultimo = " ";
    }

    public boolean getEstado(String ingresante) {

        if (ingresante.equalsIgnoreCase(ultimo)) {
            return false;
        } else {
            return this.libre;
        }

    }

    public synchronized void comer(String unNombre) {

        try {

            this.libre = false;
            this.ultimo = unNombre;
            System.out.println(unNombre + " Empezando a comer");
            Thread.sleep(util.descansa(40, 250));
            System.out.println(unNombre + " Terminando de  comer");

            this.libre = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(Comer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
