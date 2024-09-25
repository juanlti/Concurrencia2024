/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class Proceso2 extends Thread{

    Compartido unC;

    public Proceso2(Compartido unC) {
        this.unC = unC;
    }

    public void run()  {

        while (true) {
            try {
                this.unC.proceso2();
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
