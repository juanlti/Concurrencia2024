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
          //  System.out.println("sigo aca");
            comenzar = this.plato.puedoComenzar();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rotar.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

      //  System.out.println("salirrrrr " + comenzar);
        while (seguirPerros || seguirGatos) {
            
            seguirPerros = this.plato.getCantidadPerros();
               // System.out.println("PERROSSS  " + seguirPerros);

            if (seguirPerros) {
                //System.out.println("dentro perros " + seguirPerros);
                this.plato.despiertaPerros();
               // this.plato.esperar("salio perros");

            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Rotar.class.getName()).log(Level.SEVERE, null, ex);
            }

            seguirGatos = this.plato.getCantidadGatos();
            if (seguirGatos) {

                this.plato.despiertaGatos();
                //System.out.println("dentro gatos  " + seguirGatos);
               // this.plato.esperar("salio gatos");
            }
            //System.out.println("GATOOOSSSS  " + seguirGatos);

        }
        
       // System.out.println("termino    ?");

    }
}
