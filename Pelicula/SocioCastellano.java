/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelicula;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class SocioCastellano extends Thread {

    Pelicula p;
    int cantCapitulo, verCapitulo;
    boolean seguir;

    public SocioCastellano(Pelicula p) {
        this.p = p;

        seguir = true;
    }

    public void run() {
        int i = 0;
        //tomo el total de capitulos
        cantCapitulo = p.obtenerCantCapitulos();
        while (i<cantCapitulo) {
            /*
            while (i<cantCapitulo)
            */
            verCapitulo = ThreadLocalRandom.current().nextInt(0, cantCapitulo);
            this.p.sociosCastellano(verCapitulo);
            i++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(SocioCastellano.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
