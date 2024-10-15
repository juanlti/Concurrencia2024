/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Rotar extends Thread {

    Plato plato;

    public Rotar(Plato plato) {
        this.plato = plato;
    }

    public void run() {
        boolean seguirPerros = true;
        boolean seguirGatos = true;
        boolean comenzar = false;

        while (!comenzar) {
            comenzar = this.plato.puedoComenzar();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rotar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        while (seguirPerros || seguirGatos) {

            seguirPerros = this.plato.getCantidadPerros();

            if (seguirPerros) {
                this.plato.despiertaPerros();

            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rotar.class.getName()).log(Level.SEVERE, null, ex);
            }

            seguirGatos = this.plato.getCantidadGatos();
            if (seguirGatos) {

                this.plato.despiertaGatos();
            }

        }
    }
}
