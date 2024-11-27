/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelicula;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author juanc
 */
public class EnCastellano extends Thread {

    Pelicula f;

    public EnCastellano(Pelicula f) {
        this.f = f;

    }

    public void run() {
        boolean seguir = true;
        while (seguir) {
            seguir = this.f.traductorCastellano();
            try {
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(EnCastellano.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
