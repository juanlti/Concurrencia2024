/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pelicula;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class EnIngles extends Thread {
    
    Pelicula f;
    
    public EnIngles(Pelicula f) {
        this.f = f;
        
    }
    
    public void run() {
        boolean seguir = true;
        while (seguir) {

            //System.out.println("traducion a ingles");
            seguir = this.f.traductorIngles();
            try {
                Thread.sleep(350);
            } catch (InterruptedException ex) {
                Logger.getLogger(EnIngles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
