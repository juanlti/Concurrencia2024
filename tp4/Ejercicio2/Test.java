/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.Ejercicio2;

/**
 *
 * @author juanc
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        Compartido unC = new Compartido();

        Proceso3 proceso3 = new Proceso3(unC);
        Proceso2 proceso2 = new Proceso2(unC);
        Proceso1 proceso1 = new Proceso1(unC);

        proceso1.unC.proceso1();
        proceso3.unC.proceso3();
        proceso2.unC.proceso2();

        proceso1.start();
        proceso2.start();
        proceso3.start();
        proceso1.join();
        proceso2.join();
        proceso3.join();
        //System.out.println("Finalizado");

    }

}
