
package Pelicula;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author juanc
 */
public class Redactor extends Thread {

    Pelicula f;
    boolean finalizar;
    public Redactor(Pelicula f) {
        this.f = f;
        finalizar=true;
    }

    public void run() {

        while (finalizar) {
           // System.out.println("comienzo  un nuevo capituclo");
            finalizar=this.f.filmador();
            try {
                Thread.sleep(400);
                // System.out.println("finalizo un capituclo");
            } catch (InterruptedException ex) {
                Logger.getLogger(Redactor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
