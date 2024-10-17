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
public class Test {

    public static void main(String[] args) {
        Mirador mirador = new Mirador();
        Encargado encargado = new Encargado(mirador);
        Persona[] personas = new Persona[20];
        int totalPersonas = personas.length;
        for (int i = 0; i < totalPersonas; i++) {
            personas[i] = new Persona(mirador, i);

        }

        for (int i = 0; i < totalPersonas; i++) {
            personas[i].start();

        }
        encargado.start();
        for (int i = 0; i < totalPersonas; i++) {
            try {
                personas[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
