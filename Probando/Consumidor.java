/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7.Probando;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Consumidor extends Thread {

    Buffer buffer;
    int id;

    public Consumidor(Buffer buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    public void run() {
        try {
            this.buffer.consumir(this.id);
             System.out.println("Ultimo Consumidor " + this.id);
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
