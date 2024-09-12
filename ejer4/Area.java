/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Area {

    int cantReservas = 0;
    String nombreReserva = "";

    public Area(int cantReservas, String nombre) {
        this.cantReservas = cantReservas;
        this.nombreReserva = nombre;

    }

    public synchronized boolean reservar(int ocuparReserva, String nombre) {

        if (cantReservas >= ocuparReserva) {
            //seguir = true;
            this.cantReservas = cantReservas - ocuparReserva;

            try {

                System.out.println(nombre + " en reserva "+this.nombreReserva+ " disponible " + this.cantReservas+ " ocupa " + ocuparReserva );
                Thread.sleep(200);
                System.out.println("saliendo en reserva ");

            } catch (InterruptedException ex) {
                Logger.getLogger(Area.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;

        }
        return true;
    }

}
