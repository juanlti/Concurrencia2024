/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Gato extends Thread {

    Plato plato;
    int nombreGato;
    int tipoAnimal;

    public Gato(int nombreGato, Plato plato) {
        this.nombreGato = nombreGato;
        this.plato = plato;
        this.tipoAnimal = 1;
    }

    public void run() {

        int comiendo = -1;

        while (comiendo != 1) {
            try {
                comiendo = plato.ingresar(this.tipoAnimal);

                if (comiendo == this.tipoAnimal) {
                    plato.ingresoGatos(nombreGato, tipoAnimal);
                    plato.comiendo();
                    plato.saliendo(tipoAnimal);
                    System.out.println("FIN TIPO ANIMAL " + tipoAnimal + " NOMBRE ANIMAL " + nombreGato);

                } else {
                    System.out.println("TIPO ANIMAL " + tipoAnimal + " NOMBRE ANIMAL " + nombreGato);
                    Thread.sleep(200);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
