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
public class Test {

    public static void main(String[] args) {

        GestorPiscina gestorPiscina = new GestorPiscina(50);

        Visitante[] visitantes = new Visitante[60];
        int cantidadVisitantesTotales = visitantes.length;
        for (int i = 0; i < cantidadVisitantesTotales; i++) {
            visitantes[i] = new Visitante(i, gestorPiscina);

        }

        for (int i = 0; i < cantidadVisitantesTotales; i++) {
            visitantes[i].start();

        }
        for (int i = 0; i < cantidadVisitantesTotales; i++) {
            try {
                visitantes[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("finalizado");

    }

}
