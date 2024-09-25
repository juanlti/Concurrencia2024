/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.Ejercicio7;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Dato dato = new Dato(3);

        //creo 3 Impresora
        Impresora A = new Impresora('A', 4, 1, dato);
        Impresora B = new Impresora('B', 2, 2, dato);
        Impresora C = new Impresora('C', 5, 3, dato);
        
        
        A.start();
        B.start();
        C.start();
        A.join();
        B.join();
        C.join();
        System.out.println("resultado "+dato.datoFinalizado());

    }
}
