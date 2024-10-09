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
public class Perro extends Thread {

    Plato plato;
    int nombrePerro;
    int tipoAnimal;

    public Perro(int nombrePerro, Plato plato) {
        this.nombrePerro = nombrePerro;
        this.plato = plato;
        this.tipoAnimal = 2;
    }

    public void run() {

        int comiendo = -1;

        while (comiendo != 2) {
            try {
                comiendo = plato.ingresar(this.tipoAnimal);

                if (comiendo == this.tipoAnimal) {
                    plato.ingresoPerros(nombrePerro, tipoAnimal);
                    plato.comiendo();
                    plato.saliendo(tipoAnimal);
                    System.out.println("FIN TIPO ANIMAL " + tipoAnimal + " NOMBRE ANIMAL " + nombrePerro);

                } else {

                    System.out.println("TIPO ANIMAL " + tipoAnimal + " NOMBRE ANIMAL " + nombrePerro);
                    Thread.sleep(200);
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Perro.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
