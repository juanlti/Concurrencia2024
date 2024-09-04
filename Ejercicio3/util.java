/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Ejercicio3;

import java.util.Random;

/**
 *
 * @author juanc
 */
public class util {

    static int descansa(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
        // 451 es la diferencia entre 500 y 50, 
        // y luego sumamos 50 para ajustar el rango

    }

}
