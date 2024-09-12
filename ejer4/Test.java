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
public class Test {

    public static void main(String[] args) {

        Area a1 = new Area(3,"A1");//2
        Area a2 = new Area(7,"A2");// 3
        Area a3 = new Area(5,"A3"); //1
        // areas 15
        Area[] arrays = {a1, a2, a3};
        Visitante v1 = new Visitante("v1", arrays, 1);
        Visitante v2 = new Visitante("v2", arrays, 3);
        Visitante v3 = new Visitante("v3", arrays, 5);
        Visitante v4 = new Visitante("v4", arrays, 4);
      
          
        v1.start();
        v2.start();
        v3.start();
        v4.start();
   

        try {
            v1.join();
            v2.join();
            v3.join();
            v4.join();

            System.out.println("Lugares  que quedaron disponibles");
            System.out.println("a1 => " + a1.cantReservas);
            System.out.println("a2 => " + a2.cantReservas);
            System.out.println("a3 => " + a3.cantReservas);
                       
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
