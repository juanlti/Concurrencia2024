/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Visitante extends Thread {

    GestorPiscina gestorPiscina;
    int nombreVisitante;

    public Visitante(int nombreVisitante, GestorPiscina gestorPiscina) {
        this.gestorPiscina = gestorPiscina;
        this.nombreVisitante = nombreVisitante;

    }

    public void run() {

        boolean ingreso = false;
        while (!ingreso) {
            ingreso = this.gestorPiscina.ingresar(nombreVisitante);

            if (ingreso) {
                //significa que el visitante ingresa a la piscina
                this.gestorPiscina.piscina(nombreVisitante);
                ingreso = this.gestorPiscina.salir(nombreVisitante);
                System.out.println("Test debe ser true === " + ingreso);

            } else {
                try {
                    // queda esperando para volver a intentarlo (no pudo ingresar)
                    Thread.sleep(200);
                    System.out.println("Vuelve a intentarlo");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
                } finally {

                }
            }

        }

    }

}
