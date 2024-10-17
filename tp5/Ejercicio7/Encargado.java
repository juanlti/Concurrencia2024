/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.Ejercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Encargado extends Thread {

    Mirador mirador;

    public Encargado(Mirador mirador) {
        this.mirador = mirador;
    }

    public void run() {

        while (this.mirador.hayGente()) {
            try {
                Thread.sleep(100);
                this.mirador.verificarDisponibilidadT1();
                      Thread.sleep(100);
                this.mirador.verificarDisponibilidadT2();
            } catch (InterruptedException ex) {
                Logger.getLogger(Encargado.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
