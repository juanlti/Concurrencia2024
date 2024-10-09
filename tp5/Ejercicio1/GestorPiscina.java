/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio1;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class GestorPiscina {

    Semaphore cantidadDisponibilidad;

    public GestorPiscina(int cantDisponible) {
        cantidadDisponibilidad = new Semaphore(cantDisponible);
    }

    public boolean ingresar(int nombreVisitante) {
        // verifico
        System.out.println("disponibilidad " + this.cantidadDisponibilidad.availablePermits());
        if (cantidadDisponibilidad.availablePermits() > 0) {
            try {
                System.out.println("ingresa " + nombreVisitante);
                //tomo el permiso
                cantidadDisponibilidad.acquire();
                return true;
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    public void piscina(int nombreVisitante) {
        //en pisicina

        try {
            System.out.println("En piscina " + nombreVisitante);
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean salir(int nombreVisitante) {
        //devuelvo el permiso

        try {
            System.out.println("Saliendo  " + nombreVisitante);
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
        cantidadDisponibilidad.release();
        return true;

    }

}
