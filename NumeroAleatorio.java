/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrente2024.tp1.Ejercicio6;

import java.util.Random;

/**
 *
 * @author juanc
 */
public class NumeroAleatorio {

    static int distanciaRecorrida() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;

    }
    
    static int descansa(){
          Random rand = new Random();
        return rand.nextInt(451) + 50; 
        // 451 es la diferencia entre 500 y 50, 
       // y luego sumamos 50 para ajustar el rango
    
    }
    

}
