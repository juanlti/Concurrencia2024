/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejer6;

import java.util.Random;

/**
 *
 * @author juan.barrera
 */
public class util {

    static int numrosAleatorios() {

        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

}
