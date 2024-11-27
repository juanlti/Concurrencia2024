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
public class SocioIngles extends Thread {

    Pelicula p;
    int capitulo;
    int cantCapitulo;

    public SocioIngles(Pelicula p) {
        this.p = p;

    }

    public void run() {
        int i = 0;
        //tomo el total de capitulos
        cantCapitulo = p.obtenerCantCapitulos();
        while (i<cantCapitulo) {
            /*
            while (i<cantCapitulo)
            */
            capitulo = ThreadLocalRandom.current().nextInt(0, cantCapitulo);
            this.p.sociosIngles(capitulo);
            i++;
            try {
                Thread.sleep(75);
            } catch (InterruptedException ex) {
                Logger.getLogger(SocioIngles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
